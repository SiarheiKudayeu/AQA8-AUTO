package test_rail_integration;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static test_rail_integration.TestRailIntegration.StatusForTest.returnRandomStatus;

public class TestRailIntegration {

    public enum StatusForTest {
        PASSED(1), BLOCKED(2), RETEST(4), FAILED(5);
        //1 - passed, 2 - blocked, 4 - retest, 5 - failed
        private int statusValue;

        public int getStatusValue() {
            return statusValue;
        }

        public static int returnRandomStatus(){
            StatusForTest[] statusForTests = StatusForTest.values();
            return statusForTests[new Random().nextInt(statusForTests.length)].getStatusValue();
        }

        StatusForTest(int statusValue) {
            this.statusValue = statusValue;
        }
    }
    public static void main(String[] args) {
        //Получаем экземпляр TestRail
        String testRailUrl = "https://patrilcaster2.testrail.io/";
        String password = "user1User?user";
        String userName = "user@user.user";
        TestRail myTestRail = TestRail
                .builder(testRailUrl, userName, password)
                .applicationName("TestRailIntergation").build();
        System.out.println("=============PROJECTS==============");

        //Получени списка всех проектов
        List<Project> projectsList = myTestRail.projects().list().execute();
        //Получени информации о всех проектов
        for(Project project: projectsList){
            System.out.println("Name of the project is: " +project.getName() + ". " +
                    "Id of project is: " + project.getId());
        }
        System.out.println("=============SUITES==============");

        //получение списка Suite
        List<Suite> suiteList = myTestRail.suites().list(3).execute();
        for(Suite suite: suiteList){
            System.out.println("Name of the suite is: " +suite.getName() + ". " +
                    "Id of suite is: " + suite.getId());
        }
        System.out.println("=============SECTIONS==============");

        //вывод секций
        List<Section> sectionList = myTestRail.sections().list(2).execute();
        for(Section section: sectionList){
            System.out.println("Name of the section is: " +section.getName() + ". " +
                    "Id of section is: " + section.getId());
        }

        System.out.println("=============CASES==============");
        //Вывод кейсов
        List<CaseField> caseFieldsList = myTestRail.caseFields().list().execute();
        List<Case> caseList = myTestRail.cases().list(2, caseFieldsList).execute();
        for(Case testCase: caseList){
            System.out.println("Name of the testCase is: " +testCase.getTitle() + ". " +
                    "Id of testCase is: " + testCase.getId());
        }

        System.out.println("===================TEST_RUN=============");
        //создание тест рана
        String time = String.format("%1$tH:%1$tM", new Date());
        Run run = myTestRail.runs().add(2, new Run().setName("Idea Run " + time)).execute();

        //Простановка статусов для тест кейсов
        //1 - passed, 2 - blocked, 4 - retest, 5 - failed

        //соберем все айди кейсов
        List<Integer> caseId = new ArrayList<>();
        for(Case testCase: caseList){
            caseId.add(testCase.getId());
        }

        List<ResultField> resultFieldList = myTestRail.resultFields().list().execute();
        for(Integer cases: caseId){
            myTestRail.results().addForCase(run.getId(),cases, new Result().setStatusId(returnRandomStatus()), resultFieldList).execute();
        }

        //получение всех тест ранов
        List<Run> runList = myTestRail.runs().list(2).execute();
        for(Run testRun: runList){
            System.out.println("Name of the testRun is: " +testRun.getName() + ". " +
                    "Id of testRun is: " + testRun.getId() + ". isCompleted: " + testRun.isCompleted());
        }
        //закрытие тест рана
        myTestRail.runs().close(run.getId()).execute();





    }
}
