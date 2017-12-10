
package Retirement;

/*
 * Created by Jorri Carter on 12/3/17.
 * This is the final project for
 * Java Programming class with Clara James.
 * */

import static Retirement.DataProcessor.Proc;


//TODO validate user input to not be blank and to be within ranges; manage floats.
//TODO make sure parse ints work from text like $ and ,
//TODO delete old comments and fix warnings in code
//TODO add comments to complicated parts
//TODO include instructions on how to prep database for this application
//TODO tidy up code and delete cluttering comments
//TODO add alternate rows
//TODO add way to select deletion of tables
//TODO make sure clara has what she needs to run code with sqlite database
//TODO check for places where get/set can be passed directly through methods instead
//TODO print off browser and commit history to prove I've been coding all week. *-*
//TODO only save textfields to database
//TODO process for naming convention (Process.loadPrevious(title))
//TODO save to database table (DatabaseIO)
//TODO mark up first lines of methods and complicated parts. mark down all-else.
//TODO add way to name saves(for finding them)
//TODO add delete button
//TODO enable database saving (DatabaseIO)
//TODO load from database (DatabaseIO)
//TODO convert database to JTable (ToGenerator)
//TODO have load button tell processor to extract data from database
//TODO if i have too many statics, explain they are becasue I don't want multiple instances of those items as I expand the application.
//TODO shortening up long(and even medium) variable-names will make code look less compact
//TODO annual income not working isn't a broken feature
//TODO I originally planned on doint all 100,000 potential cells to aim for a good project especially because 10 at a time sounds so simple, but this way was just smarter.
//TODO Bundle similar types of code together(like get/set) so each page has as few groups(of methods) as possible

//TODO 5 MIN
//TODO clean, organized, legible, modular.
//TODO GUI speech
//TODO Database
//TODO minimize errors/input validate/exception handle/avoid errors/no bugs/complete-ish(yeah right!)
//TODO future plans for this app logic
//TODO comments throughout (not everywhere: useful for complexity) block comments at top (name/class/contents)
//TODO attribute oracle.docs
//TODO demonstration: (talk about difficulties).
//TODO DEMONSTRATE modularity and ease of upscaling with additional textboxes/formulas.


class RetirementCalculatorProgram {


    public static void main(String[] args) {

        Proc.startProgram();

        DB db = new DB(); db.DBTableMaker();

//        DatabaseIO.createNewDatabase("test.db");

//        DatabaseIO.tablePlacer();

//        DatabaseIO app = new DatabaseIO();

//        app.selectAll();
    }
}