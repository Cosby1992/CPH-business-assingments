package main.generated.edmaimpl.models.mydatamodel;

import main.generated.edmaimpl.models.mydatamodel.CourseSetImpl;
import main.generated.edmaimpl.models.mydatamodel.CourseVUImpl;
import main.generated.mydatamodel.kinds.course.CourseKind;
import main.generated.mydatamodel.kinds.course.CourseSet;
import main.generated.mydatamodel.kinds.course.CourseViewer;
import main.generated.valuedomains.Name;
import main.generated.valuedomains.mydatamodel.CourseID;
import org.abstractica.edma.runtime.intf.IDataModelView;
import org.abstractica.edma.runtime.intf.IEntity;
import org.abstractica.edma.valuedomains.IValueInstance;

/**
 * 
 */
public class CourseKindImpl implements CourseKind
{
    private int edma_kindIndex;
    private IDataModelView edma_dmview;



    /**
     * Constructor
     * @param edma_kindIndex  kind index
     * @param edma_dmview     Internal runtime interface
     */
    public CourseKindImpl(int edma_kindIndex, IDataModelView edma_dmview)
    {
        this.edma_kindIndex = edma_kindIndex;
        this.edma_dmview = edma_dmview;
    }

    /**
     * Get an entity from its id.
     * @param id  The id of the entity to get
     * @return    A viewer on the entity with the given ID or null if none
     *            exists.
     */
    public CourseViewer getFromID(CourseID id)
    {
        IEntity res = edma_dmview.kindGetFromID(edma_kindIndex, id.value());
        if(res == null) return null;
        return new CourseVUImpl(res, edma_dmview);
    }

    /**
     * Returns an empty set of Course entities.
     * @return  An empty set of Course entities.
     */
    public CourseSet getEmptyCourseSet()
    {
        int newSetID = edma_dmview.kindGetEmptySet(1);
        return new CourseSetImpl(newSetID, edma_dmview);
    }

    /**
     * Returns the set of all Course entities.
     * @return  The set of all Course entities.
     */
    public CourseSet getAll()
    {
        int newSetID = edma_dmview.kindGetAll(1);
        return new CourseSetImpl(newSetID, edma_dmview);
    }

    /**
     * Returns the unique course from the unique-index on name or <tt>null</tt>
     * if there is no course with the given name.
     * @param name  Value for name
     * @return      The unique course from the unique-index on name or
     *              <tt>null</tt> if there is no course with the given name.
     */
    public CourseViewer getFromName(Name name)
    {
        Object[] edma_values = new Object[1];
        edma_values[0] = ((IValueInstance) name).edma_getValue();
        IEntity res = edma_dmview.getKindIndex(1, 0).getFromUnique(edma_values);
        if(res == null) return null;
        return new CourseVUImpl(res, edma_dmview);
    }
}
