/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ics4u.scottsandre.unit6;

public interface HashTableInterface {

    public int size();

    public void resize();

    public int capacity();

    public void loadFactor();

    public void makeEmpty();

    public void isEmpty();

    public int get( int key );

    public void put( int value );

    public void containsKey( int key );

    public int hash( int key );

}