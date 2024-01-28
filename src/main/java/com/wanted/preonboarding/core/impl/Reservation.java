package com.wanted.preonboarding.core.impl;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(
        name = "reservation",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "reservation_round_row_seat",
                        columnNames = {"performance_id", "round", "line", "seat"}
                )
        })
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Comment("공연전시ID")
    @Column(name = "performance_id", nullable = false)
    private UUID performanceId;

    @Comment("예약자명")
    @Column(name = "name", nullable = false)
    private String name;

    @Comment("예약자 휴대전화 번호")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Comment("회차(FK)")
    @Column(name = "round", nullable = false)
    private int round;

    @Comment("입장 게이트")
    @Column(name = "gate", nullable = false)
    private int gate;

    @Comment("좌석 열")
    @Column(name = "line", nullable = false)
    private char line;

    @Comment("좌석 행")
    @Column(name = "seat", nullable = false)
    private int seat;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(UUID performanceId) {
        this.performanceId = performanceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getGate() {
        return gate;
    }

    public void setGate(int gate) {
        this.gate = gate;
    }

    public char getLine() {
        return line;
    }

    public void setLine(char line) {
        this.line = line;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
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
        if (!(o instanceof Reservation that)) return false;
        return getRound() == that.getRound() && getGate() == that.getGate() && getLine() == that.getLine() && getSeat() == that.getSeat() && Objects.equals(getId(), that.getId()) && Objects.equals(getPerformanceId(), that.getPerformanceId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getPhoneNumber(), that.getPhoneNumber()) && Objects.equals(getCreatedAt(), that.getCreatedAt()) && Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPerformanceId(), getName(), getPhoneNumber(), getRound(), getGate(), getLine(), getSeat(), getCreatedAt(), getUpdatedAt());
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", performanceId=" + performanceId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", round=" + round +
                ", gate=" + gate +
                ", line=" + line +
                ", seat=" + seat +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
