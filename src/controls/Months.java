/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

/**
 *
 * @author sushant saini
 */
public enum Months {
   January(31),February(28),March(31),April(30),May(31),June(30),July(31),
    August(31),September(30),October(31),November(30),December(31);
    
private int days;

    public int getDays() {
        return days;
    }

    private Months(int days) {
        this.days = days;
    }

        
       
}
