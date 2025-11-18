package controller;

import java.util.ArrayList;

public abstract class Searching<T> {

    protected abstract ArrayList<T> searchAll(String t);
    protected abstract ArrayList<T> searchName(String t);
    protected abstract ArrayList<T> searchID(String t);
}

