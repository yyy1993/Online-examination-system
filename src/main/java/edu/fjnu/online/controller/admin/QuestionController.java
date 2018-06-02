package edu.fjnu.online.controller.admin;

import com.github.pagehelper.PageInfo;
import edu.fjnu.online.controller.BaseController;
import edu.fjnu.online.domain.Course;
import edu.fjnu.online.domain.Grade;
import edu.fjnu.online.domain.Question;
import edu.fjnu.online.domain.Type;
import edu.fjnu.online.service.CourseService;
import edu.fjnu.online.service.GradeService;
import edu.fjnu.online.service.QuestionService;
import edu.fjnu.online.service.TypeService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.FileNameMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 题库管理
 * @author hspcadmin
 *
 */
@Controller
public class QuestionController extends BaseController {
	

	@Autowired
	QuestionService questionService;
	@Autowired
	CourseService courseService;
	@Autowired
	TypeService typeService;
	@Autowired
	GradeService gradeService;
	/**
	 * 跳转到题库管理页面
	 * @param question
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/toQuestionPage.action")
	public String toQuestionPage(@RequestParam(value="page", defaultValue="1") int page,
			Question question,Model model, HttpSession session){
	    System.out.println("enter addQuestion11！");
		PageInfo<Question> pageInfo = questionService.findByPage(question, page, 5);
		List<Question> dataList = pageInfo.getList();
		Course course=null;
		Type type=null;
		for(Question que : dataList){
			String courseName= "";
			String typeName="";
			/*course = courseService.get(Integer.parseInt(que.getCourseId()));
			type = typeService.get(Integer.parseInt(que.getTypeId()));
			courseName=course.getCourseName();
			typeName=type.getTypeName();
			que.setCourseId(courseName);
			que.setTypeId(typeName);*/
		}
		model.addAttribute("dataList", dataList);
		model.addAttribute("pageInfo", pageInfo);
		return "/admin/question-mgt.jsp";			
	}
	
	/**
	 * 跳转到题库管理页面
	 * @param question
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/quesPage.action")
	@ResponseBody
	public List<Question> quesPage(@RequestParam(value="page", defaultValue="1") int page,
			Question question,Model model, HttpSession session){
//		List<Question> dataList = questionService.find(question);
		PageInfo<Question> pageInfo = questionService.findByPage(question, page, 5);
		List<Question> dataList = pageInfo.getList();
		Course course=null;
		Type type=null;
		/*for(Question que : dataList){
			String courseName= "";
			String typeName="";
			course = courseService.get(Integer.parseInt(que.getCourseId()));
			type = typeService.get(Integer.parseInt(que.getTypeId()));
			courseName=course.getCourseName();
			typeName=type.getTypeName();
			que.setCourseId(courseName);
			que.setTypeId(typeName);
		}*/
		model.addAttribute("dataList", dataList);
		model.addAttribute("pageInfo", pageInfo);
		return dataList;			
	}
	
	/**
	 * 删除问题信息
	 * @param questionId	问题编号，删除多个是，id用逗号分隔开
	 * @param model
	 * @return
	 */
	@RequestMapping("/deleteQuestion.action")
	public String deleteQuestion(String questionId, Model model){
		if(questionId != null){
			String ids[] = questionId.split(",");
			for(int i=0;i<ids.length;i++){
				questionService.delete(Integer.parseInt(ids[i]));
			}
		}
		return "redirect:/toQuestionPage.action";
	}

	/**
	 * 跳转到添加试题信息页面
	 * @param question
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/toAddQuestion.action")
	public String toAddQuestion(Question question, Model model, HttpSession session){
		//获取问题信息
		List<Question> dataList = questionService.find(question);
		//获取课程信息
		List<Course> courseList = courseService.find(new Course());
		//获取年级信息
		model.addAttribute("grade", gradeService.find(new Grade()));
		//获取题型信息
		model.addAttribute("type", typeService.find(new Type()));
		model.addAttribute("dataList", dataList);
		model.addAttribute("course", courseList);
		return "/admin/question-reg.jsp";			
	}

    /**
     * 添加试题信息
     * @param question
     * @param model
     * @return
     */
    @RequestMapping("/addQuesInfoByFile.action")
    public String addQuesInfoByFile(Model model, HttpServletRequest req) throws FileNotFoundException {

        //得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
        String savePath = req.getSession().getServletContext().getRealPath("/WEB-INF/upload");
        String uploadFile = null;
        File file = new File(savePath);
        if (!file.exists()) {
            //创建目录
            file.mkdir();
        }
        try
        {
            //使用Apache文件上传组件处理文件上传步骤：
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中。
            factory.setSizeThreshold(1024*100);//设置缓冲区的大小为100KB，如果不指定，那么缓冲区的大小默认是10KB
            //设置上传时生成的临时文件的保存目录
            factory.setRepository(file);
            //2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 设置文件字符编码格式
            upload.setHeaderEncoding("utf-8");

            List<FileItem> list = upload.parseRequest(req);
            for(FileItem item : list)
            {
                String fileName = item.getName();
                //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
                //获取item中的上传文件的输入流
                InputStream in = item.getInputStream();
                //创建一个文件输出流
                FileOutputStream out = new FileOutputStream(savePath + "\\" + fileName);
                //创建一个缓冲区
                byte buffer[] = new byte[1024];
                //判断输入流中的数据是否已经读完的标识
                int len = 0;
                //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                while((len=in.read(buffer))>0){
                    //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                    out.write(buffer, 0, len);
                }
                //关闭输入流
                in.close();
                //关闭输出流
                out.close();
                //删除处理文件上传时生成的临时文件
                item.delete();
                uploadFile = savePath + "\\" + fileName;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        Boolean rowNoEmpty = false;
        try
        {
            XSSFWorkbook xwb = new XSSFWorkbook(new FileInputStream(new File(uploadFile)));
            // 读取第一张表格内容
            XSSFSheet sheet = xwb.getSheetAt(0);
            XSSFRow row = null;
            XSSFCell cell = null;
            for (int i = (sheet.getFirstRowNum() + 1); i <= (sheet.getPhysicalNumberOfRows() - 1); i++)
            {
                row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                Question question = new Question();
                for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++)
                {
                    Object value = null;
                    cell = row.getCell(j);
                    if (cell == null) {
                        continue;
                    }
                    switch (cell.getCellType())
                    {
                        case XSSFCell.CELL_TYPE_STRING:
                            //String类型返回String数据
                            value = cell.getStringCellValue();
                            break;
                        case XSSFCell.CELL_TYPE_NUMERIC:
                                //数值类型返回double类型的数字
                                //System.out.println(cell.getNumericCellValue()+":格式："+cell.getCellStyle().getDataFormatString());
                                value = cell.getNumericCellValue();
                            break;
                        case XSSFCell.CELL_TYPE_BOOLEAN:
                            //布尔类型
                            value = cell.getBooleanCellValue();
                            break;
                        case XSSFCell.CELL_TYPE_BLANK:
                            //空单元格
                            break;
                        default:
                            value = cell.toString();
                    }
                    if (value != null && !value.equals(""))
                    {
                        rowNoEmpty = true;
                        switch (j)
                        {
                            case 0 :
                                question.setQuesName(value.toString());
                                break;
                            case 1:
                                if(value.toString().equals("单选题"))
                                {
                                    question.setQuestionForm(0);
                                }
                                else if(value.toString().equals("多选题"))
                                {
                                    question.setQuestionForm(1);
                                }
                                break;
                            case 2:
                                if(value.toString().equals("专业题"))
                                {
                                    question.setQuestionType(0);
                                }
                                else if(value.toString().equals("逻辑题"))
                                {
                                    question.setQuestionType(1);
                                }
                                else if(value.toString().equals("心理题"))
                                {
                                    question.setQuestionType(2);
                                }
                                break;
                            case 3:
                                question.setOptionA(value.toString());
                                break;
                            case 4:
                                question.setScoreA(Integer.parseInt(new java.text.DecimalFormat("0").format(value)));
                                break;
                            case 5:
                                question.setOptionB(value.toString());
                                break;
                            case 6:
                                question.setScoreB(Integer.parseInt(new java.text.DecimalFormat("0").format(value)));
                                break;
                            case 7:
                                question.setOptionC(value.toString());
                                break;
                            case 8:
                                question.setScoreC(Integer.parseInt(new java.text.DecimalFormat("0").format(value)));
                                break;
                            case 9:
                                question.setOptionD(value.toString());
                                break;
                            case 10:
                                question.setScoreD(Integer.parseInt(new java.text.DecimalFormat("0").format(value)));
                                break;
                            case 11:
                                question.setOptionE(value.toString());
                                break;
                            case 12:
                                question.setScoreE(Integer.parseInt(new java.text.DecimalFormat("0").format(value)));
                                break;
                            case 13:
                                question.setOptionF(value.toString());
                                break;
                            case 14:
                                question.setScoreF(Integer.parseInt(new java.text.DecimalFormat("0").format(value)));
                                break;
                            case 15:
                                question.setAnswer(value.toString());
                                break;
                            case 16:
                                question.setAnswerDetail(value.toString());
                                break;
                            case 17:
                                question.setRemark(value.toString());
                                break;
                            default:
                                System.out.println("insert question error!");
                        }
                    }
                }
                if(rowNoEmpty)
                {
                    rowNoEmpty = false;
                    questionService.insert(question);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return "/admin/question-mgt.jsp";
    }

	/**
	 * 添加试题信息
	 * @param question
	 * @param model
	 * @return
	 */
	@RequestMapping("/addQuesInfo.action")
	public String addQuesInfo(Question question, Model model){
		questionService.insert(question);
		return "redirect:/toQuestionPage.action";			
	}
	
	/**
	 * 查看问题信息
	 * @param questionId 问题编号
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/toQryQuestion.action")
	public String toQryQuestion(int questionId, Model model, HttpSession session){
		Question questionInfo = questionService.get(questionId);
		/*Grade grade = gradeService.get(Integer.parseInt(questionInfo.getGradeId()));
		Course course = courseService.get(Integer.parseInt(questionInfo.getCourseId()));
		Type type = typeService.get(Integer.parseInt(questionInfo.getTypeId()));
		questionInfo.setGradeId(grade.getGradeName());
		questionInfo.setCourseId(course.getCourseName());
		questionInfo.setTypeId(type.getTypeName());*/
		model.addAttribute("question", questionInfo);
		return "/admin/question-qry.jsp";			
	}
	
	/**
	 * 跳转到更新题目信息页面
	 * @param type
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/toUpdQuestion.action")
	public String toUpdQuestion(int questionId, Model model, HttpSession session){
		Question questionInfo = questionService.get(questionId);
		model.addAttribute("question", questionInfo);
		List<Grade>gradeList = gradeService.find(new Grade());
		List<Course>courseList = courseService.find(new Course());
		List<Type> typeList = typeService.find(new Type());
		model.addAttribute("gradeList", gradeList);
		model.addAttribute("courseList", courseList);
		model.addAttribute("typeList", typeList);
		return "/admin/question-upd.jsp";			
	}
	
	/**
	 * 更新题目信息
	 * @param type
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/updQuestion.action")
	public String updQuestion(Question question, Model model, HttpSession session){
		questionService.update(question);
		return "redirect:/toQuestionPage.action";			
	}
	
	/**
	 * 删除问题信息
	 * @param type
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/delQuestion.action")
	public String delQuestion(int questionId, Model model, HttpSession session){
		questionService.delete(questionId);
		return "redirect:/todelQuestionPage.action";			
	}
}
