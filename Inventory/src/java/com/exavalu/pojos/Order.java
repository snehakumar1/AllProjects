/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.pojos;

/**
 *
 * @author Lenovo
 */
public class Order {
    private int order_id;
    private String customaer_name;
    private String order_date;
    private double order_value;
    private double tax_amount;
    private String destination_city;
    private String destination_country;
    

    /**
     * @return the order_id
     */
    public int getOrder_id() {
        return order_id;
    }

    /**
     * @param order_id the order_id to set
     */
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    /**
     * @return the customaer_name
     */
    public String getCustomaer_name() {
        return customaer_name;
    }

    /**
     * @param customaer_name the customaer_name to set
     */
    public void setCustomaer_name(String customaer_name) {
        this.customaer_name = customaer_name;
    }

    /**
     * @return the order_date
     */
    public String getOrder_date() {
        return order_date;
    }

    /**
     * @param order_date the order_date to set
     */
    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    /**
     * @return the order_value
     */
    public double getOrder_value() {
        return order_value;
    }

    /**
     * @param order_value the order_value to set
     */
    public void setOrder_value(double order_value) {
        this.order_value = order_value;
    }

    /**
     * @return the tax_amount
     */
    public double getTax_amount() {
        return tax_amount;
    }

    /**
     * @param tax_amount the tax_amount to set
     */
    public void setTax_amount(double tax_amount) {
        this.tax_amount = tax_amount;
    }

    /**
     * @return the destination_city
     */
    public String getDestination_city() {
        return destination_city;
    }

    /**
     * @param destination_city the destination_city to set
     */
    public void setDestination_city(String destination_city) {
        this.destination_city = destination_city;
    }

    /**
     * @return the destination_country
     */
    public String getDestination_country() {
        return destination_country;
    }

    /**
     * @param destination_country the destination_country to set
     */
    public void setDestination_country(String destination_country) {
        this.destination_country = destination_country;
    }

    /**
     * @return the subtotal
     */
    
}
