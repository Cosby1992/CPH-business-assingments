package main.generated.edmaimpl.models.mydatamodel;

import main.generated.edmaimpl.models.mydatamodel.PersonSetImpl;
import main.generated.edmaimpl.models.mydatamodel.PersonVUImpl;
import main.generated.mydatamodel.kinds.course.CourseUpdater;
import main.generated.mydatamodel.kinds.course.CourseViewer;
import main.generated.mydatamodel.kinds.person.PersonSet;
import main.generated.mydatamodel.kinds.person.PersonViewer;
import main.generated.valuedomains.Name;
import main.generated.valuedomains.impl.NameImpl;
import main.generated.valuedomains.mydatamodel.Course;
import main.generated.valuedomains.mydatamodel.CourseID;
import main.generated.valuedomains.mydatamodel.impl.CourseIDImpl;
import main.generated.valuedomains.mydatamodel.impl.CourseImpl;
import org.abstractica.edma.runtime.intf.IDataModelView;
import org.abstractica.edma.runtime.intf.IEntity;

/**
 * 
 */
public class CourseVUImpl implements CourseUpdater, CourseViewer
{
    protected IEntity edma_entity;
    private IDataModelView edma_dmview;



    /**
     * Constructor
     * @param edma_entity  Internal entity
     * @param edma_dmview  Internal runtime interface
     */
    public CourseVUImpl(IEntity edma_entity, IDataModelView edma_dmview)
    {
        this.edma_entity = edma_entity;
        this.edma_dmview = edma_dmview;
    }

    /**
     * Create a copy of this Course at this instance in time
     * @return  A copy of this Course entity as a value  from the value domain
     *          Course
     */
    public Course snapshot()
    {
        Object[] res = new Object[2];
        Object[] internal = edma_entity.getValue();
        res[0] = internal[0];
        res[1] = internal[1];
        return new CourseImpl(res);
    }

    /**
     * Returns the ID of this Course
     * @return  The ID of this Course
     */
    public CourseID getID()
    {
        return new CourseIDImpl(edma_entity.getID());
    }

    /**
     * Returns the attribute name of this Course
     * @return  The value of the attribute name
     */
    public Name getName()
    {
        return new NameImpl(edma_entity.getValue()[1]);
    }

    /**
     * This methods follows the relation CourseEnrollment
     * @return  The result of following the relation CourseEnrollment
     */
    public PersonSet getStudentSet()
    {
        int setID = edma_dmview.relationAsAGetBSet(0, edma_entity.getID());
        return new PersonSetImpl(setID, edma_dmview);
    }

    /**
     * This methods follows the relation TeacherAssignment
     * @return  The result of following the relation TeacherAssignment
     */
    public PersonViewer getTeacher()
    {
        Long resID = edma_dmview.relationAsAGetB(1, edma_entity.getID());
        if(resID == null) return null;
        IEntity entity = edma_dmview.kindGetFromID(0, resID);
        return new PersonVUImpl(entity, edma_dmview);
    }

    /**
     * Returns <tt>true</tt> if this entity has the same ID as the provided
     * entity
     * @param o  The object to compare with
     * @return   <tt>true</tt> if this entity has the same ID as the provided
     *           entity
     */
    public boolean equals(Object o)
    {
        if(!(o instanceof CourseViewer)) return false;
        CourseViewer other = (CourseViewer) o;
        return getID().equals(other.getID());
    }

    /**
     * Returns the hash code of this entity
     * @return  The hash code of this entity
     */
    public int hashCode()
    {
        return getID().hashCode();
    }

    /**
     * Connects the student to this Course, if it is not already connected.
     *  This method has been generated from the relation:
     *  CourseEnrollment
     * @param student  The student to be added. May NOT be null.
     * @return         <tt>true</tt> if this course was not already connected
     *                 to the specified student
     */
    public boolean addStudent(PersonViewer student)
    {
        PersonVUImpl B = (PersonVUImpl) student;
        return edma_dmview.getUpdateInterface().relationAdd(0, edma_entity.getID(), B.edma_entity.getID());
    }

    /**
     * Removes the student from this Course, if it is connected.
     *  This method has been generated from the relation:
     *  CourseEnrollment
     * @param student  The student to be connected to this course. May NOT be
     *                 null.
     * @return         <tt>true</tt> if the specified student was connected to
     *                 this course
     */
    public boolean removeStudent(PersonViewer student)
    {
        PersonVUImpl edma_b = (PersonVUImpl) student;
        return edma_dmview.getUpdateInterface().relationDelete(0, edma_entity.getID(), edma_b.edma_entity.getID());
    }

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
    public PersonViewer setTeacher(PersonViewer teacher)
    {
        Long b_ID = null;
        if(teacher != null)
        {
            b_ID = ((PersonVUImpl) teacher).edma_entity.getID();
        }
        Long res = edma_dmview.getUpdateInterface().relationReplaceB(1, edma_entity.getID(), b_ID);
        if(res == null) return null;
        IEntity ent = edma_dmview.kindGetFromID(0, res);
        return new PersonVUImpl(ent, edma_dmview);
    }
}
