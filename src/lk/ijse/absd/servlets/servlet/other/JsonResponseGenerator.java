package lk.ijse.absd.servlets.servlet.other;

import lk.ijse.absd.servlets.dto.CustomerDTO;
import lk.ijse.absd.servlets.dto.ItemDTO;
import lk.ijse.absd.servlets.dto.OrderDTO;
import lk.ijse.absd.servlets.dto.OrderDetailDTO;

import javax.json.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Tharindu
 * Date: 2019-04-06
 * Time: 06:57 PM
 */
public class JsonResponseGenerator {

    public JsonObject getByCustomerDTO(CustomerDTO customerDTO){
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        objectBuilder.add("cid",customerDTO.getCid());
        objectBuilder.add("name",customerDTO.getName());
        objectBuilder.add("address",customerDTO.getAddress());
        objectBuilder.add("mobile",customerDTO.getMobile());
        return objectBuilder.build();
    }

    public JsonArray getByCustomerDTOList(List<CustomerDTO> customerDTOS){
        JsonArrayBuilder jsonArrayBuilder=Json.createArrayBuilder();
        customerDTOS.forEach(customerDTO -> {
            jsonArrayBuilder.add(getByCustomerDTO(customerDTO));
        });
        return jsonArrayBuilder.build();
    }

    public JsonObject getByItemDTO(ItemDTO itemDTO){
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        objectBuilder.add("code",itemDTO.getCode());
        objectBuilder.add("name",itemDTO.getName());
        objectBuilder.add("price",itemDTO.getPrice());
        objectBuilder.add("qty",itemDTO.getQty());
        return objectBuilder.build();
    }

    public JsonArray getByItemDTOList(List<ItemDTO> itemDTOS){
        JsonArrayBuilder jsonArrayBuilder=Json.createArrayBuilder();
        itemDTOS.forEach(ItemDTO -> {
            jsonArrayBuilder.add(getByItemDTO(ItemDTO));
        });
        return jsonArrayBuilder.build();
    }

    public JsonObject getByOrderDTO(OrderDTO orderDTO){
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        objectBuilder.add("oid",orderDTO.getOid());
        objectBuilder.add("date",orderDTO.getDate().toString());
        objectBuilder.add("total",orderDTO.getTotal());
        objectBuilder.add("cid",orderDTO.getCid());
        if(orderDTO.getName()!=null){
            objectBuilder.add("name",orderDTO.getName());
        }
        return objectBuilder.build();
    }

    public JsonArray getByOrderDTOList(List<OrderDTO> orderDTOS){
        JsonArrayBuilder jsonArrayBuilder=Json.createArrayBuilder();
        orderDTOS.forEach(OrderDTO -> {
            jsonArrayBuilder.add(getByOrderDTO(OrderDTO));
        });
        return jsonArrayBuilder.build();
    }

    public JsonObject getByOrderDetailDTO(OrderDetailDTO orderDetailDTO){
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        objectBuilder.add("code",orderDetailDTO.getCode());
        objectBuilder.add("qty",orderDetailDTO.getQty());
        objectBuilder.add("oid",orderDetailDTO.getOid());
        objectBuilder.add("unitPrice",orderDetailDTO.getUnitPrice());
        return objectBuilder.build();
    }

    public JsonArray getByOrderDetailDTOList(List<OrderDetailDTO> orderDetailDTOS){
        JsonArrayBuilder jsonArrayBuilder=Json.createArrayBuilder();
        orderDetailDTOS.forEach(orderDetailDTO  -> {
            jsonArrayBuilder.add(getByOrderDetailDTO(orderDetailDTO));
        });
        return jsonArrayBuilder.build();
    }

    public JsonObject getForCommonResponse(Integer code, String message){
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        objectBuilder.add("code",code);
        objectBuilder.add("message",message);
        return objectBuilder.build();
    }
}
