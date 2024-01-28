package com.wanted.preonboarding.core.impl;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "performance")
public class Performance {
    @Id
    @Comment("공연/전시 ID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Comment("공연/전시 이름")
    @Column(name = "name", nullable = false)
    private String name;

    @Comment("가격")
    @Column(name = "price", nullable = false)
    private int price;

    @Comment("회차")
    @Column(name = "round", nullable = false)
    private int round;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private PerformanceType type;

    @Comment("공연 일시")
    @Column(name = "start_date", nullable = false)
    private Instant startDate;

    @Comment("자리 점유 여부")
    @Column(name = "is_reserve", nullable = false)
    private boolean isReserve;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public PerformanceType getType() {
        return type;
    }

    public void setType(PerformanceType type) {
        this.type = type;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public boolean isReserve() {
        return isReserve;
    }

    public void setReserve(boolean reserve) {
        isReserve = reserve;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Performance that)) return false;
        return getPrice() == that.getPrice() && getRound() == that.getRound() && isReserve() == that.isReserve() && Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && getType() == that.getType() && Objects.equals(getStartDate(), that.getStartDate()) && Objects.equals(getCreatedAt(), that.getCreatedAt()) && Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice(), getRound(), getType(), getStartDate(), isReserve(), getCreatedAt(), getUpdatedAt());
    }

    @Override
    public String toString() {
        return "Performance{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", round=" + round +
                ", type=" + type +
                ", startDate=" + startDate +
                ", isReserve=" + isReserve +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

