package com.ueniweb.swiftwaresolutions.data;

import com.ueniweb.swiftwaresolutions.domain.Prescription;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

@Data
public class PrescriptionDetailsData {

        private Long id;

        private Prescription prescriptionId;

        private Long genericId;

        private Long prodsId;

        private Double quantity;

        private Double unit;

        private Double qno;

        private Long timing;

        private Long duration;

        private Long period;

        private Long route;

        private Long instruction;

        private String date;

        private Long isOrderPrepared;

        private Long orderId;

        private Long isPaid;

        private Long isOwn;

        private Long isCancelled;

        private Long batchId;

        private String notes;

        public PrescriptionDetailsData(Long id, Prescription prescriptionId, Long genericId,
                                       Long prodsId, Double quantity, Double unit, Double qno,
                                       Long timing, Long duration, Long period, Long route,
                                       Long instruction, String date, Long isOrderPrepared,
                                       Long orderId, Long isPaid, Long isOwn, Long isCancelled,
                                       Long batchId, String notes) {
                this.id = id;
                this.prescriptionId = prescriptionId;
                this.genericId = genericId;
                this.prodsId = prodsId;
                this.quantity = quantity;
                this.unit = unit;
                this.qno = qno;
                this.timing = timing;
                this.duration = duration;
                this.period = period;
                this.route = route;
                this.instruction = instruction;
                this.date = date;
                this.isOrderPrepared = isOrderPrepared;
                this.orderId = orderId;
                this.isPaid = isPaid;
                this.isOwn = isOwn;
                this.isCancelled = isCancelled;
                this.batchId = batchId;
                this.notes = notes;
        }

        public static PrescriptionDetailsData createNewInstance(final Long id, final Prescription prescriptionId, final Long genericId,
                                                                final Long prodsId, final Double quantity, final Double unit, final Double qno,
                                                                final Long timing, final Long duration, final Long period, final Long route,
                                                                final Long instruction, final String date, final Long isOrderPrepared,
                                                                final Long orderId, final Long isPaid, final Long isOwn, final Long isCancelled,
                                                                final Long batchId, final String notes){
                return createNewInstance(id, prescriptionId, genericId, prodsId, quantity, unit, qno, timing, duration, period, route, instruction, date, isOrderPrepared, orderId, isPaid, isOwn, isCancelled, batchId, notes);
        }
}
