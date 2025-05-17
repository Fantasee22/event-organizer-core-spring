package com.event_organizer_core_spring.service.impl

import com.event_organizer_core_spring.core.dto.request.GenericByIdRequest
import com.event_organizer_core_spring.dao.OrderDao
import com.event_organizer_core_spring.dto.request.order.OrderRequest
import com.event_organizer_core_spring.dto.response.order.OrderResponse
import com.event_organizer_core_spring.model.entity.OrderEntity
import com.event_organizer_core_spring.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl (
    @Autowired
    val orderDao: OrderDao
) : OrderService {
    override fun addOrder(orderRequest: OrderRequest): OrderResponse {
        TODO("Not yet implemented")
    }

    override fun editOrder(orderRequest: OrderRequest): OrderResponse {
        TODO("Not yet implemented")
    }

    override fun getOrderById(genericByIdRequest: GenericByIdRequest): OrderResponse {
        TODO("Not yet implemented")
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