package Controller;

import Model.ClassManager;
import Model.LectureDTO;
import View.RealFilterView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class RealFilterController {
    private RealFilterView realFilter;

    public RealFilterController() {
        realFilter = new RealFilterView();
        realFilter.addInterestingListener(new InterestingListener());
        realFilter.addSearchListener(new SearchListener());
        realFilter.addExitButtonListener(new ExitButtonListener());
        realFilter.addValueListener(new ValueListener());
    }

    public RealFilterView getRealFilterView() {return realFilter;}

    //filter를 하는 메소드 Iterator를 활용해 필터
    public void filteredLecture() {
    	realFilter.filteredLectureList  = new ArrayList<LectureDTO>();
        for (int i = 0; i < ClassManager.getInstance().getLecture().size(); i++ ) { // 개설 학과 전공 필터
            if (realFilter.filterMajorInfo.equals("") || ClassManager.getInstance().getLecture().get(i).major.equals(realFilter.filterMajorInfo))
                realFilter.filteredLectureList.add(ClassManager.getInstance().getLecture().get(i));
        }

        Iterator<LectureDTO> iter = realFilter.filteredLectureList.iterator(); // 학수번호
        while (iter.hasNext()) {
            LectureDTO lvo = iter.next();
            if (!(realFilter.filterCourseNumInfo.equals(""))) {
                if (!lvo.courseNum.equals(realFilter.filterCourseNumInfo)) {
                    iter.remove();
                } // if
            } // if
        } // while

        iter = realFilter.filteredLectureList.iterator(); // 교과목명
        while (iter.hasNext()) {
            LectureDTO lvo = iter.next();
            if (!(realFilter.filterClassNameInfo.equals(""))) {
                if (!lvo.className.equals(realFilter.filterClassNameInfo)) {
                    iter.remove();
                } // if
            } // if
        } // while

        iter = realFilter.filteredLectureList.iterator(); // 교수명
        while (iter.hasNext()) {
            LectureDTO lvo = iter.next();
            if (!(realFilter.filterProInfo.equals(""))) {
                if (!lvo.professor.equals(realFilter.filterProInfo)) {
                    iter.remove();
                } // if
            } // if
        } // while

        iter = realFilter.filteredLectureList.iterator(); // 학년
        while (iter.hasNext()) {
            LectureDTO lvo = iter.next();
            if (realFilter.filterGradeInfo != -1) {
                if (lvo.grade != realFilter.filterGradeInfo) {
                    iter.remove();
                } // if
            } // if
        } // while

        iter = realFilter.filteredLectureList.iterator(); // 분반
        while (iter.hasNext()) {
            LectureDTO lvo = iter.next();
            if (!(realFilter.filterClassNumInfo.equals(""))) {
                if (!lvo.classNum.equals(realFilter.filterClassNameInfo)) {
                    iter.remove();
                } // if
            } // if
        } // while

        iter = realFilter.filteredLectureList.iterator(); // 이수 구분
        while (iter.hasNext()) {
            LectureDTO lvo = iter.next();
            if (!(realFilter.filterCompInfo.equals(""))) {
                if (!lvo.completion.equals(realFilter.filterCompInfo)) {
                    iter.remove();
                } // if
            } // if
        } // while

    } // filteredLecture

    private class InterestingListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                realFilter.onlyInterested = true;
                realFilter.setEnabledAll(false);
            } else {
                realFilter.onlyInterested = false;
                realFilter.setEnabledAll(true);
            } // if... else
        }  // itemStateChanged
    } // InterestingListener

    private class ValueListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();

            if (obj == realFilter.cbxMajor) { // 개설학과전공
                JComboBox cbx = (JComboBox) obj;
                realFilter.filterMajorInfo = (String) cbx.getSelectedItem();
            } else if (obj == realFilter.txtCourseNum) { // 학수번호
                JTextField txt = (JTextField) obj;
                realFilter.filterCourseNumInfo = txt.getText();
            } else if (obj == realFilter.txtClassName) { // 교과목명
                JTextField txt = (JTextField) obj;
                realFilter.filterClassNameInfo = txt.getText();
            } else if (obj == realFilter.txtProfessor) { // 교수명
                JTextField txt = (JTextField) obj;
                realFilter.filterProInfo = txt.getText();
            } else if (obj == realFilter.cbxGrade) { // 학년
                JComboBox cbx = (JComboBox) obj;
                realFilter.filterGradeInfo = Integer.parseInt((String) Objects.requireNonNull(cbx.getSelectedItem()));
                if (realFilter.filterGradeInfo == 0) realFilter.filterGradeInfo = -1; // 필터할 때 학년 구분 없이 검색할 때 쓰기 위함
            } else if (obj == realFilter.txtClassNum) { // 분반
                JTextField txt = (JTextField) obj;
                realFilter.filterClassNumInfo = txt.getText();
            } else if (obj == realFilter.cbxCompletion){ // 이수 구분
                JComboBox cbx = (JComboBox) obj;
                realFilter.filterCompInfo = (String) cbx.getSelectedItem();
            }
        }
    }

    private class SearchListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();
            ClassManager.getInstance().getLectureListController().getLLV().isFavorite = false;
            if (realFilter.onlyInterested) {
            	ClassManager.getInstance().getLectureListController().setSearchListAtLectureListView(ClassManager.getInstance().getInterested());
 				ClassManager.getInstance().getMain().changePanel(ClassManager.getInstance().getLectureListController().getLLV());
            } else {
                filteredLecture();
                ClassManager.getInstance().getLectureListController().setSearchListAtLectureListView(realFilter.filteredLectureList);
				ClassManager.getInstance().getMain().changePanel(ClassManager.getInstance().getLectureListController().getLLV());
            } // if... else

        }// actionPerformed
    } // SearchListener

 // ConditionListener

    private class ExitButtonListener implements ActionListener { // 나가기 버튼
        @Override
        public void actionPerformed(ActionEvent e) {
            ClassManager.getInstance().getMain().comeToMain();
        } // actionPerformed
    } // ExitButtonListener

} // RealFilterController Class
