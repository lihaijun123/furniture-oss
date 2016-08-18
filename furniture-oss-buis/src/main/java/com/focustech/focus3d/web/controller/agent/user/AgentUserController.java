package com.focustech.focus3d.web.controller.agent.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.focustech.common.utils.DateUtils;
import com.focustech.common.utils.HttpUtil;
import com.focustech.common.utils.StringUtils;
import com.focustech.common.utils.TCUtil;
import com.focustech.focus3d.model.agent.auth.AgentRole;
import com.focustech.focus3d.model.agent.product.AgentProduct;
import com.focustech.focus3d.model.agent.user.AgentLogin;
import com.focustech.focus3d.model.agent.user.AgentUser;
import com.focustech.focus3d.service.agent.auth.AgentRoleService;
import com.focustech.focus3d.service.agent.product.AgentProductService;
import com.focustech.focus3d.service.agent.user.AgentLoginService;
import com.focustech.focus3d.service.agent.user.AgentUserService;
import com.focustech.oss2008.web.AbstractController;

/**
 *
 * *
 * @author lihaijun
 *
 */
@Controller
@RequestMapping(value = "/agentUser.do")
public class AgentUserController extends AbstractController{
	@Autowired
	private AgentUserService<AgentUser> agentUserService;
	@Autowired
	private AgentProductService<AgentProduct> agentProductService;
	@Autowired
	private AgentLoginService<AgentLogin> agentLoginService;
	@Autowired
	private AgentRoleService<AgentRole> agentRoleService;
	/**
	 *
	 * *
	 * @param request
	 * @param modelMap
	 */
	@ModelAttribute
	public void setModelAttribute(HttpServletRequest request, ModelMap modelMap){
		List<AgentProduct> productList = agentProductService.getListByStatus(1);
		List<AgentProduct> productListFilter = new ArrayList<AgentProduct>();
		for (AgentProduct agentProduct : productList) {
			if(TCUtil.isEmpty(agentProduct.getTagName())){
				productListFilter.add(agentProduct);
			}
		}
		modelMap.addAttribute("productList", productListFilter);
		//角色信息
		List<AgentRole> agentRoleList = agentRoleService.selectByActive(1);
		modelMap.addAttribute("agentRoleList", agentRoleList);
		modelMap.addAttribute("message", HttpUtil.sv(request, "message"));
	}
	/**
	 *
	 * *
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=new", method = RequestMethod.GET)
	public String _new(ModelMap modelMap){
		AgentUser agentUser = new AgentUser();
		modelMap.addAttribute("agentUser", agentUser);
		return "/focus3d/agent/user/new";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=create", method = RequestMethod.POST)
	public String create(AgentUser agentUser, BindingResult result,ModelMap modelMap){
		String view = "/focus3d/agent/user/edit";
		String mobilePhone = agentUser.getMobilePhone();
		if(StringUtils.isNotEmpty(mobilePhone)){
			AgentUser exist  = agentUserService.getByMobilePhone(mobilePhone);
			if(exist != null){
				modelMap.addAttribute("message", "手机号已存在，请更换");
				view = "/focus3d/agent/user/new";
			} else {
				exist = agentUserService.getByPartnerId(agentUser.getPartnerId());
				if(exist != null){
					modelMap.addAttribute("message", "合同编号已存在");
					view = "/focus3d/agent/user/new";
				} else {
					agentUser.setRegChannelType(3);
					agentUserService.save(agentUser);
					modelMap.addAttribute("message", "添加成功");
				}
			}
		}
		modelMap.addAttribute("agentUser", agentUser);
		return view;
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=edit", method = RequestMethod.GET)
	public String edit(Long sn, HttpServletRequest request, ModelMap modelMap){
		AgentUser agentUser = agentUserService.select(sn);
		modelMap.addAttribute("agentUser", agentUser);
		List<AgentProduct> agentProducts = agentProductService.getListByUserId(agentUser.getSn());
		modelMap.addAttribute("userProductList", agentProducts);
		return "/focus3d/agent/user/edit";
	}
	/**
	 *
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=edit", method = RequestMethod.POST)
	public String edit(AgentUser agentUser, BindingResult result,ModelMap modelMap){
		String view = redirectTo("/agentUser.do?method=edit&sn=" + agentUser.getSn() + "&message=" + HttpUtil.encodeUrl("修改成功"));
		String mobilePhone = agentUser.getMobilePhone();
		if(StringUtils.isNotEmpty(mobilePhone)){
			AgentUser exist  = agentUserService.getByMobilePhone(mobilePhone);
			if(exist != null && !exist.getSn().equals(agentUser.getSn())){
				modelMap.addAttribute("message", "手机号已存在，请更换");
			} else {
				exist = agentUserService.getByPartnerId(agentUser.getPartnerId());
				if(exist != null && !exist.getSn().equals(agentUser.getSn())){
					modelMap.addAttribute("message", "合同编号已存在");
					view = "/focus3d/agent/user/edit";
				} else {
					agentUserService.save(agentUser);
				}
			}
		}
      modelMap.addAttribute("agentUser", agentUser);
      List<AgentProduct> agentProducts = agentProductService.getListByUserId(agentUser.getSn());
      modelMap.addAttribute("userProductList", agentProducts);
      return view;
	}
	/**
	 * 重置密码
	 * *
	 * @param bannerInfo
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=resetpwd", method = RequestMethod.POST)
	public void resetPwd(String userId, HttpServletResponse response, ModelMap modelMap){
		if(StringUtils.isNotEmpty(userId)){
			agentLoginService.resetPwd(TCUtil.lv(userId));
		}
		JSONObject jo = new JSONObject();
		jo.put("isSucess", true);
		try {
			ajaxOutput(response, jo.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 *
	 * *
	 * @param sn
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=delete", method = RequestMethod.GET)
	public String delete(Long sn, HttpServletRequest request, ModelMap modelMap){
		AgentUser agentUser = agentUserService.select(sn);
		if(agentUser != null){
			agentUser.setStatus(9);
			agentUserService.update(agentUser);
		}
		return redirectTo("/uitoolList.ui?funcID=1080339");
	}
	/**
	 *
	 * *
	 * @param sn
	 * @param request
	 * @param response
	 * @param modelMap
	 * @throws IOException
	 */
	@RequestMapping(params = "method=downloadsqs", method = RequestMethod.GET)
	public void downloadsqs(Long sn, HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws IOException{
		AgentUser agentUser = agentUserService.select(sn);
		byte[] data = null;
		String type = "";
		if(agentUser != null){
			data = getAgentAuthCard(agentUser);
			Integer partnerType = agentUser.getPartnerType();
			if(TCUtil.iv(partnerType) == 1){
				type = "个人";
			} else {
				type = "企业";
			}
		}
		download(data, "授权证明_" + type + "_" + agentUser.getUserName() + ".jpg", request, response);
	}
	/**
	 * 个人授权卡
	 * *
	 * @param agentUser
	 * @return
	 * @throws IOException
	 */
	private byte[] getAgentAuthCard(AgentUser agentUser) throws IOException {
		byte[] byteArray = null;
		Integer partnerType = agentUser.getPartnerType();
		String userName = agentUser.getUserName();
		String idCard = agentUser.getIdCard().replaceAll("(?<=[\\d]{4})\\d(?=[\\d]{2})", "*");
		String mobilePhone = agentUser.getMobilePhone().replaceAll("(?<=[\\d]{3})\\d(?=[\\d]{4})", "*");
		String wxId = agentUser.getWxId();
		String agentGrade = "";//AgentUserGradeType.getName(agentUser.getAgentGrade());
		AgentRole agentRole = agentRoleService.select(TCUtil.lv(agentUser.getAgentGrade()));
		if(agentRole != null){
			agentGrade = agentRole.getRoleName();
		}
		String partnerId = agentUser.getPartnerId();
		if(StringUtils.isNotEmpty(partnerId) && partnerId.length() > 6){
			partnerId = partnerId.substring(6, partnerId.length());
		}
		Date validStartDate = agentUser.getValidStartDate();
		Date validEndDate = agentUser.getValidEndDate();
		String companyName = agentUser.getCompanyName();
		String homeUrl = "http://www.3d-focus.com";
		Resource resource = null;
		BufferedImage buffImage = null;
		Graphics g = null;
		if (TCUtil.iv(partnerType) == 1) {
			// 个人
			resource = new ClassPathResource("/context/template/agent_auth_personal.jpg");
			buffImage = ImageIO.read(resource.getFile());
			g = buffImage.getGraphics();
			g.setColor(new Color(79, 147, 140));
			g.setFont(new Font("黑体", Font.BOLD, 60));
			// 名称
			g.drawString(userName, 785, 1515);
			// 身份证
			g.drawString(idCard, 1445, 1515);
			// 联系方式
			g.drawString(mobilePhone, 785, 1640);
			// 微信号
			g.drawString(wxId, 1440, 1650);
		} else {
			// 企业
			resource = new ClassPathResource("/context/template/agent_auth_company.jpg");
			buffImage =  ImageIO.read(resource.getFile());
			g = buffImage.getGraphics();
			g.setColor(new Color(79, 147, 140));
			g.setFont(new Font("黑体",Font.BOLD, 60));
			//公司名
			g.drawString(companyName, 785, 1515);
			//联系方式
			g.drawString(mobilePhone, 785, 1640);
		}
		try {
			// 授权级别
			g.drawString(agentGrade, 785, 2050);
			// 授权编号
			g.drawString(partnerId, 785, 2170);
			// 授权期限
			g.drawString(DateUtils.formatDate(validStartDate, "yyyy年MM月dd日") + " 至 " + DateUtils.formatDate(validEndDate, "yyyy年MM月dd日"), 785, 2300);
			// 查询网址
			g.drawString(homeUrl, 785, 2430);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			try {
				ImageIO.write(buffImage, "jpg", out);
				byteArray = out.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (out != null) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return byteArray;
	}
	/**
	 *
	 * *
	 * @param filePath
	 * @param fileName
	 * @param request
	 * @param response
	 */
	private static void download(byte[] data, String fileName, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/octet-stream;charset=UTF-8");
        ServletOutputStream out = null;
        BufferedInputStream bufferedInStream = null;
        try {
        	if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0){
        		//IE
        		fileName = URLEncoder.encode(fileName, "UTF-8");
        	}else if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
        		//firefox
        		fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
        	}else{
        		// other
        		fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
        	}
        	response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");

            out = response.getOutputStream();
            out.write(data);
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            try {
                if (null != bufferedInStream) {
                	bufferedInStream.close();
                }
                if (out != null) {
                    out.flush();
                    out.close();
                }
            }
            catch (IOException e1) {
            	e1.printStackTrace();
            }
        }
    }

}
