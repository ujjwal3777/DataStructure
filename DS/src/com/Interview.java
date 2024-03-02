package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Interview {

    public static void main (String ... args) {
        Family test = new Family();
        test.gender = "MALE";
        test.name = "ASHOKA";

        Family firstChildNext = new Family();
        firstChildNext.gender ="MALE";
        firstChildNext.name = "Damyanti";
        firstChildNext.left =null;
        firstChildNext.right = null;
        Family firstChild = new Family();
        firstChild.gender ="MALE";
        firstChild.name = "BALA";
        firstChild.left =firstChildNext;
        firstChild.right = null;
        Family secondChildNext = new Family();
        secondChildNext.gender ="MALE";
        secondChildNext.name = "Kailas";
        secondChildNext.left =null;
        secondChildNext.right = null;
        Family secondChild = new Family();
        secondChild.gender ="FEMALE";
        secondChild.name = "CHANDRA";
        secondChild.left = secondChildNext;
        secondChild.right = null;
        test.left =firstChild;
        test.right = secondChild;
        levelOrder(test);
    }

    public static void levelOrder(Family root) {
        if (root == null)
            return;
        Queue<Family> familyGeneration = new LinkedList<Family>();
        familyGeneration.add(root);
        familyGeneration.add(null);

        while(!familyGeneration.isEmpty()) {
            Family next = familyGeneration.remove();
            if(next == null) {
                System.out.println();
                if(familyGeneration.isEmpty()) {
                    break;
                } else {
                    familyGeneration.add(null);
                }
            } else if (next.gender.equalsIgnoreCase("MALE")) {
                if (next.left != null) {
                    familyGeneration.add(next.left);
                }
                if (next.right != null) {
                    familyGeneration.add(next.right);
                }
                System.out.print(next.name + ",");
            } else {
                System.out.print(next.name + ",");
            }



        }

    }

}
