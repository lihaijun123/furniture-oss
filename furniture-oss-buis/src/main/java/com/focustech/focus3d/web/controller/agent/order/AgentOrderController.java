package com.focustech.focus3d.web.controller.agent.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focustech.common.utils.StringUtils;
import com.focustech.focus3d.model.agent.order.AgentOrder;
import com.focustech.focus3d.model.agent.order.AgentOrderItem;
import com.focustech.focus3d.model.agent.order.AgentOrderLogtc;
import com.focustech.focus3d.model.agent.order.AgentOrderTrans;
import com.focustech.focus3d.model.agent.order.AgentReceiveAddress;
import com.focustech.focus3d.service.agent.order.AgentOrderItemService;
import com.focustech.focus3d.service.agent.order.AgentOrderLogtcService;
import com.focustech.focus3d.service.agent.order.AgentOrderService;
import com.focustech.focus3d.service.agent.order.AgentOrderTransService;
import com.focustech.focus3d.service.agent.order.AgentReceiveAddressService;
import com.focustech.oss2008.web.AbstractController;

/**
 *
 * *
 * @author lihaijun
 *
 */
@Controller
@RequestMapping(value = "/agentOrder.do")
public class AgentOrderController extends AbstractController{
	@Autowired
	private AgentOrderService<AgentOrder> agentOrderService;
	@Autowired
	private AgentOrderItemService<AgentOrderItem> agentOrderItemService;
	@Autowired
	private AgentReceiveAddressService<AgentReceiveAddress> agentReceiveAddressService;
	@Autowired
	private AgentOrderLogtcService<AgentOrderLogtc> agentOrderLogtcService;
	@Autowired
	private AgentOrderTransService<AgentOrderTrans> orderTransService;

	/**
	 *
	 * *
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=edit", method = RequestMethod.GET)
	public String edit(Long sn, ModelMap modelMap){
		AgentOrder agentOrder = agentOrderService.select(sn);
		List<AgentOrderItem> agentOrderItems = agentOrderItemService.getByOrderId(sn);
		AgentReceiveAddress agentReceiveAddress = agentReceiveAddressService.select(agentOrder.getReceiveAddressId());
		AgentOrderLogtc agentOrderLogtc = agentOrderLogtcService.getByOrderId(sn);
		agentOrder.setItems(agentOrderItems);
		AgentOrderTrans agentOrderTrans = orderTransService.getByOrderId(agentOrder.getOrderNum());
		agentOrder.setAgentOrderTrans(agentOrderTrans);
		if(agentReceiveAddress != null){
			agentOrder.setRevAddress(agentReceiveAddress);
		}
		if(agentOrderLogtc != null){
			agentOrder.setOrderLogtc(agentOrderLogtc);
		}
		modelMap.addAttribute("agentOrder", agentOrder);
		return "/focus3d/agent/order/edit";
	}
	/**
	 *
	 * *
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(params = "method=edit", method = RequestMethod.POST)
	public String edit(AgentOrder agentOrder, BindingResult result,ModelMap modelMap){
		//agentOrderService.update(agentOrder);
		Long sn = agentOrder.getSn();
		AgentOrderLogtc orderLogtc = null;
		if(sn != null){
			orderLogtc = agentOrder.getOrderLogtc();
			Double totalPrice = agentOrder.getTotalPrice();
			if(totalPrice > 0){
				agentOrder = agentOrderService.select(sn);
				agentOrder.setTotalPrice(totalPrice);
				agentOrderService.update(agentOrder);
			}
		}
		if(orderLogtc != null){
			Long orderLogtcSn = orderLogtc.getSn();
			if(orderLogtcSn != null){
				String logtcName = orderLogtc.getLogtcName();
				String logtcId = orderLogtc.getLogtcId();
				orderLogtc = agentOrderLogtcService.select(orderLogtcSn);
				orderLogtc.setLogtcName(logtcName);
				orderLogtc.setLogtcId(logtcId);
				if(StringUtils.isNotEmpty(orderLogtc.getLogtcId())){
					orderLogtc.setIsSend(1);
				}
				agentOrderLogtcService.update(orderLogtc);
			}
		}
		return redirectTo("/agentOrder.do?method=edit&sn=" + sn);
	}

	@RequestMapping(params = "method=delete", method = RequestMethod.GET)
	public String delete(Long sn, HttpServletRequest request, ModelMap modelMap){
		AgentOrder agentOrder = agentOrderService.select(sn);
		if(agentOrder != null){
			Integer status = agentOrder.getStatus();
			if(status != 3){
				agentOrderService.delete(agentOrder);
			}
		}
		return redirectTo("/uitoolList.ui?funcID=1080340");
	}
}
