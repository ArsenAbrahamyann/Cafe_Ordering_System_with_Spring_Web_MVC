package com.picsartacademy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @NotNull
    @Column(name = "waiter_id")
    private Long waiterId;

    @NotNull
    @Column(name = "table_number")
    private Long tableNumber;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "order")
    private List<OrderItem> items;

    public Order() {
    }

    public Order(Long id, Long waiterId, Long tableNumber, List<OrderItem> items) {
        this.id = id;
        this.waiterId = waiterId;
        this.tableNumber = tableNumber;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(Long waiterId) {
        this.waiterId = waiterId;
    }

    public Long getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Long tableNumber) {
        this.tableNumber = tableNumber;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(waiterId, order.waiterId) && Objects.equals(tableNumber, order.tableNumber) && Objects.equals(items, order.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, waiterId, tableNumber, items);
    }

    @Override
    public String toString() {
        return "Order{" +
               "id=" + id +
               ", waiterId=" + waiterId +
               ", tableNumber=" + tableNumber +
               ", items=" + items +
               '}';
    }
}
