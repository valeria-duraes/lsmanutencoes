package lsmanut_system.modules.service_orders.dto;

import lombok.Data;
import jakarta.validation.constraints.*;
import lsmanut_system.modules.service_orders.entity.enums.PaymentMethod;
import lsmanut_system.modules.service_orders.entity.enums.StatusPayment;
import lsmanut_system.modules.service_orders.entity.enums.StatusBudget;
import lsmanut_system.modules.service_orders.entity.enums.StatusDelivery;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Data
public class OrderUpdateDTO {
    @NotBlank
    private String m_name;

    private String m_model;

    @NotNull
    private Integer voltage;

    private String brand;

    private String serial_number;

    private String accessories;

    private String observations;

    public BigDecimal service_cost;

    private Map<String, Object> parts;

    @NotNull
    private StatusBudget status_budget;

    @NotNull
    private StatusDelivery status_delivery;

    @NotNull
    private StatusPayment status_payment;

    @NotNull
    private PaymentMethod payment_method;

    private LocalDateTime service_date;
}

