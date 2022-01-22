package com.endiluamba.payroll.assemblers;

import com.endiluamba.payroll.controllers.OrderController;
import com.endiluamba.payroll.entities.Order;
import com.endiluamba.payroll.entities.Status;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OrderModelAssembler implements RepresentationModelAssembler<com.endiluamba.payroll.entities.Order, EntityModel<com.endiluamba.payroll.entities.Order>> {

    @Override
    public EntityModel<com.endiluamba.payroll.entities.Order> toModel(com.endiluamba.payroll.entities.Order order) {

        EntityModel<Order> orderModel = EntityModel.of(order,
                linkTo(methodOn(OrderController.class).one(order.getId())).withSelfRel(),
                linkTo(methodOn(OrderController.class).all()).withRel("orders"));

        if (order.getStatus() == Status.IN_PROGRESS) {
            orderModel.add(linkTo(methodOn(OrderController.class).cancel(order.getId())).withRel("cancel"));
            orderModel.add(linkTo(methodOn(OrderController.class).complete(order.getId())).withRel("complete"));
        }

        return orderModel;
    }
}
