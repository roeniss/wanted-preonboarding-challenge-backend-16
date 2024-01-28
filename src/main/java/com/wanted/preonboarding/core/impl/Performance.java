package com.wanted.preonboarding.core.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.proxy.HibernateProxy;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
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

    @JsonIgnore
    @OneToMany(mappedBy = "performance", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PerformanceSeatInfo> seats = new LinkedHashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private PerformanceType type;

    @Comment("공연 일시")
    @Column(name = "start_date", nullable = false)
    private Instant startDate;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    public void addSeat(PerformanceSeatInfo seat) {
        seats.add(seat);
        seat.setPerformance(this);
    }

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

    public Set<PerformanceSeatInfo> getSeats() {
        return seats;
    }

    public void setSeats(Set<PerformanceSeatInfo> seats) {
        this.seats = seats;
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
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Performance that = (Performance) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}

