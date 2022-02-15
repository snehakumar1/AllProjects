/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ots.test.beans;

import java.util.Date;

/**
 *
 * @author Sayani
 */
public class Tickets {
    private int ticketId;
    private String type;
    private String description;
    private int assignedTo;
    private Date assignedDate;
    private int ticketStatusId;
    private Date solvedDate;

    /**
     * @return the ticketId
     */
    public int getTicketId() {
        return ticketId;
    }

    /**
     * @param ticketId the ticketId to set
     */
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the assignedTo
     */
    public int getAssignedTo() {
        return assignedTo;
    }

    /**
     * @param assignedTo the assignedTo to set
     */
    public void setAssignedTo(int assignedTo) {
        this.assignedTo = assignedTo;
    }

  

    /**
     * @return the ticketStatusId
     */
    public int getTicketStatusId() {
        return ticketStatusId;
    }

    /**
     * @param ticketStatusId the ticketStatusId to set
     */
    public void setTicketStatusId(int ticketStatusId) {
        this.ticketStatusId = ticketStatusId;
    }



    /**
     * @return the assignedDate
     */
    public Date getAssignedDate() {
        return assignedDate;
    }

    /**
     * @param assignedDate the assignedDate to set
     */
    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    /**
     * @param solvedDate the solvedDate to set
     */
    public void setSolvedDate(Date solvedDate) {
        this.solvedDate = solvedDate;
    }

    /**
     * @return the solvedDate
     */
    public Date getSolvedDate() {
        return solvedDate;
    }
}
