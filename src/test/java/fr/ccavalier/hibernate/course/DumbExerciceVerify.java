package fr.ccavalier.hibernate.course;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ccavalie on 30/01/2017.
 */
public class DumbExerciceVerify {
	DumbExercice  exercice = new DumbExercice();

    @Test
    public void dumbTest(){
        Assert.assertTrue(exercice.isTrue());
    }


}