package com.event_organizer_core_spring.service.impl

import com.event_organizer_core_spring.core.dto.request.GenericByIdRequest
import com.event_organizer_core_spring.dao.OrderDao
import com.event_organizer_core_spring.dao.ServiceDao
import com.event_organizer_core_spring.dto.request.order.OrderRequest
import com.event_organizer_core_spring.dto.response.order.OrderResponse
import com.event_organizer_core_spring.model.Order
import com.event_organizer_core_spring.model.entity.OrderEntity
import com.event_organizer_core_spring.model.entity.toModel
import com.event_organizer_core_spring.model.toEntity
import com.event_organizer_core_spring.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl (
    @Autowired
    val orderDao: OrderDao,
    @Autowired
    val serviceDao: ServiceDao
) : OrderService {
    override fun addOrder(orderRequest: OrderRequest): OrderResponse {
        TODO("Not yet implemented")
    }

    override fun editOrder(orderRequest: OrderRequest): OrderResponse {
        val order = Order(
            id = orderRequest.id,
            orderNo = orderRequest.orderNo,
            totalPrice = orderRequest.totalPrice,
            totalPaid = orderRequest.totalPaid,
            orderStatus = orderRequest.orderStatus,
            startTime = orderRequest.startTime,
            endTime = orderRequest.endTime,
            service = serviceDao.findServiceById(orderRequest.serviceId, useException = true),
            customer = null,
            pic = null //TODO: not done yet for the repo and dao
        )

        val editOrder = orderDao.editOrder(order.toEntity()).toModel()

        return OrderResponse(
            id = editOrder.id,
            orderNo = editOrder.orderNo
        )
    }

    override fun getOrderById(genericByIdRequest: GenericByIdRequest): OrderResponse {
        val orderObj = orderDao.findOrderById(genericByIdRequest.id ?: 0);
        if (orderObj != null) {
            return OrderResponse (
                id = orderObj.id,
                orderNo = orderObj.orderNo,
                totalPrice = orderObj.totalPrice,
                totalPaid = orderObj.totalPaid,
                orderStatus = orderObj.orderStatus,
                startTime = orderObj.startTime,
                endTime = orderObj.endTime
            )
        }
        return OrderResponse(id = 0)
    }

    override fun getAllOrder(): List<OrderResponse> {
        val listOfOrder: List<OrderEntity> = orderDao.getAllOrder()
        val listOfOrderRes: List<OrderResponse> = listOfOrder.map { orderObj ->
            OrderResponse (
                id = orderObj.id,
                orderNo = orderObj.orderNo,
                totalPrice = orderObj.totalPrice,
                totalPaid = orderObj.totalPaid,
                orderStatus = orderObj.orderStatus,
                startTime = orderObj.startTime,
                endTime = orderObj.endTime
            )
        }

        return listOfOrderRes;
    }
}