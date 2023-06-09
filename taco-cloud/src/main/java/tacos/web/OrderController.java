//tag::injectAndUseRepo[]
package tacos.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import tacos.TacoOrder;
import tacos.data.OrderRepository;

@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

	private OrderRepository orderRepo;

	public OrderController(OrderRepository aOrderRepo) {
		this.orderRepo = aOrderRepo;
	}

//end::injectAndUseRepo[]

	@GetMapping("/current")
	public String orderForm( Model model ) {
		return "orderForm";
	}

	/*
	 * //tag::injectAndUseRepo[] // ... //end::injectAndUseRepo[]
	 */

//tag::injectAndUseRepo[]
	@PostMapping
	public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus, Model model) {
		if (errors.hasErrors()) {
			return "orderForm";
		}

		orderRepo.save(order);
		sessionStatus.setComplete();

		return "redirect:/";
	}

}
//end::injectAndUseRepo[]