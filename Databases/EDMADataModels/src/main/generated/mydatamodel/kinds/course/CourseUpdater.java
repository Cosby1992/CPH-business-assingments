package main.generated.mydatamodel.kinds.course;

import main.generated.mydatamodel.kinds.person.PersonViewer;

/**
 * This is the update interface for Course
 */
public interface CourseUpdater extends CourseViewer
{

    /**
     * Connects the student to this Course, if it is not already connected.
     *  This method has been generated from the relation:
     *  CourseEnrollment
     * @param student  The student to be added. May NOT be null.
     * @return         <tt>true</tt> if this course was not already connected
     *                 to the specified student
     */
    public boolean addStudent(PersonViewer student);

    /**
     * Removes the student from this Course, if it is connected.
     *  This method has been generated from the relation:
     *  CourseEnrollment
     * @param student  The student to be connected to this course. May NOT be
     *                 null.
     * @return         <tt>true</tt> if the specified student was connected to
     *                 this course
     */
    public boolean removeStudent(PersonViewer student);

    /**
     * Sets the teacher for this Course. If another teacher is already set, it
     * will be replaced.
     *  This method has been generated from the relation:
     *  TeacherAssignment
     * @param teacher  The teacher to be set. Use null to remove any previous
     *                 connection.
     * @return         The previous teacher connected to this course or null if
     *                 none was connected.
     */
    public PersonViewer setTeacher(PersonViewer teacher);

}
