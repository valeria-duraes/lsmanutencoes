package lsmanut_system.modules.service_orders.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lsmanut_system.modules.customers.entity.Customer;
import lsmanut_system.modules.service_orders.entity.enums.PaymentMethod;
import lsmanut_system.modules.service_orders.entity.enums.StatusBudget;
import lsmanut_system.modules.service_orders.entity.enums.StatusDelivery;
import lsmanut_system.modules.service_orders.entity.enums.StatusPayment;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Map;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "service_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String m_name;

    @Column
    private String m_model;

    @Column(nullable = false)
    private Integer voltage;

    @Column
    private String brand;

    @Column
    private String serial_number;

    @Column
    private String accessories;

    @Column
    private String observations;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updated_at;

//    @Column(nullable = false)
//    private Integer customerId;

    @ManyToOne
    @JoinColumn(
            name = "customerId",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_order_customer")
    )
    private Customer customer;

    @Column(precision = 20, scale = 2)
    private BigDecimal service_cost;

//    @Type(type = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    private Map<String, Object> parts;

//    @Column(nullable = false)
//    private String status_budget;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "enum_machines_status_budget default 'pending'")
    private StatusBudget status_budget;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "enum_machines_status_delivery default 'not_delivered'")
    private StatusDelivery status_delivery;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "enum_machines_status_payment default 'unpaid'")
    private StatusPayment status_payment;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", nullable = false, columnDefinition = "enum_machines_payment_method default 'cash'")
    private PaymentMethod payment_method;

    @Column(updatable = true)
    private LocalDateTime service_date;
}
