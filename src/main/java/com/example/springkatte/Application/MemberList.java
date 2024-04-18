package com.example.springkatte.Application;

import java.util.ArrayList;

import com.example.springkatte.Domain.User;

public class MemberList {
    ArrayList<User> Members = new ArrayList<>();

    public MemberList() {
    }

    public void addMember(User user) {
        Members.add(user);
    }

    public void removeMember(User user) {
        Members.remove(user);
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

    @Override
    public String toString() {
        return "MemberList{" +
                "Members=" + Members +
                '}';
    }
}
