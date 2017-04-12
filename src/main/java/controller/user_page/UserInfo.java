package controller.user_page;

import model.dao.UserInfoEntityDao;
import model.entity.user.UserEntity;
import model.entity.user.UserInfoEntity;
import model.service.updateUserInfo.UpdateUserInfo;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by LJ on 2017/4/11.
 */
@Controller
public class UserInfo {

    @Resource
    private UserInfoEntityDao userInfoEntityDao;

    @RequestMapping(path = "/user/info",method = RequestMethod.GET)
    public String userInfo( Model model,HttpSession session){
        UserEntity user =(UserEntity) session.getAttribute("superUser");
        UserInfoEntity userInfo = userInfoEntityDao.selectUserInfoByUserId(user.getId());
        model.addAttribute("userInfo",userInfo);
        return "/WEB-INF/user_center/user_info.jsp";
    }

    @RequestMapping(path = "/user/updateInfo",method = RequestMethod.POST)
    public String userInfo(@RequestParam("alice")MultipartFile file, String name, Integer phone, Boolean sex, HttpSession session) throws IOException {

        UserEntity user = (UserEntity)session.getAttribute("superUser");

        UpdateUserInfo updateUserInfo = new UpdateUserInfo();
        updateUserInfo.updateUserInfo(file, userInfoEntityDao,name, phone, sex, user);

        return "redirect:/user/info";
    }
}
