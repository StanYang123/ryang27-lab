package edu.iit.sat.itmd4515.ryang27.web;

import edu.iit.sat.itmd4515.ryang27.pojo.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/**
 * @author Wang.Kone
 * @date 2023/10/5 18:42
 */

@Controller
public class EventWeb {

    @Resource
    Validator validator;

    @jakarta.annotation.Resource(name = "java:app/jdbc/itmd4515DS")
    DataSource ds;

    @RequestMapping(value = "/index")
    public ModelAndView speak(Model model) {
        ModelAndView mv=new ModelAndView();
        mv.setViewName("customer");
        return mv;
    }

    @PostMapping("/add")
    @ResponseBody
    public ModelAndView post(HttpServletRequest request) throws ParseException {
        String query = request.getQueryString();

        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String type = request.getParameter("type");
        String remark = request.getParameter("remark");

        if (date==""){
            ModelAndView mv=new ModelAndView();

            mv.addObject("remark",remark);
            mv.addObject("date",date);
            mv.addObject("name",name);
            mv.addObject("type",type);

            mv.setViewName("customer");

            return mv;
        }

        Event event = new Event();
        event.setName(name);
        event.setRemark(remark);
        event.setType(type);
        Date date1=null;
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        date1=formatter.parse(date);
        event.setDate(date1);
        Set<ConstraintViolation<Event>> violations = validator.validate(event);
        if (violations.size()>0){
            ModelAndView mv=new ModelAndView();

            mv.addObject("remark",event.getRemark());
            mv.addObject("date",event.getDate());
            mv.addObject("name",event.getName());
            mv.addObject("type",event.getType());
            mv.addObject("error","About type and remark must be between 1 and 200 characters");

            mv.setViewName("customer");

            return mv;
        }else {
            ModelAndView mv=new ModelAndView();
            mv.addObject("remark",event.getRemark());
            mv.addObject("date",event.getDate());
            mv.addObject("name",event.getName());
            mv.addObject("type",event.getType());

            mv.setViewName("answer");
            return mv;
        }

    }

}
