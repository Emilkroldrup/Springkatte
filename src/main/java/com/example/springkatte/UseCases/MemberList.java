package com.example.springkatte.UseCases;

import com.example.springkatte.Model.User;

import java.util.ArrayList;

public class MemberList {
    ArrayList<User> Members = new ArrayList<>();

    public MemberList() {
    }

    public void addMember(User user) {
        Members.add(user);
    }

    public ArrayList<User> getMembers() {
        return Members;
    }

    public void setMembers(ArrayList<User> members) {
        Members = members;
    }

    public MemberList(ArrayList<User> members) {
        Members = members;
    }

}
