package main.generated;

import java.util.ArrayList;
import java.util.Collection;
import main.generated.edmaimpl.models.mydatamodel.MyDataModelFactoryImpl;
import org.abstractica.edma.metamodel.IMetaEnvironment;
import org.abstractica.edma.metamodel.IMetaIndex.IndexType;
import org.abstractica.edma.metamodel.IMetaRelation.RelationType;
import org.abstractica.edma.metamodel.impl.MetaAttribute;
import org.abstractica.edma.metamodel.impl.MetaDataModel;
import org.abstractica.edma.metamodel.impl.MetaEnvironment;
import org.abstractica.edma.metamodel.impl.MetaIndex;
import org.abstractica.edma.metamodel.impl.MetaKind;
import org.abstractica.edma.metamodel.impl.MetaMethod;
import org.abstractica.edma.metamodel.impl.MetaRelation;
import org.abstractica.edma.metamodel.impl.ValueDomainBuilder;
import org.abstractica.edma.metamodel.impl.ValueDomainBuilder.Field;
import org.abstractica.edma.runtime.implementations.mem.modelstore.speed.newindex.IndexUtil;
import org.abstractica.edma.runtime.intf.IRuntimeFactory;
import org.abstractica.edma.valuedomains.impl.Constraint;

/**
 * 
 */
public class EDMADataModels
{
    public static final IMetaEnvironment environment = generateEnvironment();
    private MyDataModelFactoryImpl edma_MyDataModel;



    /**
     * generate the environment
     * @return  
     */
    public static IMetaEnvironment generateEnvironment()
    {
        ValueDomainBuilder vdb = new ValueDomainBuilder();
        
        //Integer value domain: Year
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newIntegerDomain("Year", null, 0, 9999, edma_constraints, false);
        }
        
        //Integer value domain: Month
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newIntegerDomain("Month", null, 1, 12, edma_constraints, false);
        }
        
        //Integer value domain: DayOfMonth
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newIntegerDomain("DayOfMonth", null, 1, 31, edma_constraints, false);
        }
        
        //Struct value domain: Date
        {
            ArrayList<Constraint> edma_constraints = new ArrayList<Constraint>(1);
            edma_constraints.add(new Constraint("validDate", "No description given"));
            Collection<Field> fields = new ArrayList<Field>();
            fields.add(vdb.newStructField("year", "Year", false));
            fields.add(vdb.newStructField("month", "Month", false));
            fields.add(vdb.newStructField("day", "DayOfMonth", false));
            vdb.newStructDomain("Date", null, fields, edma_constraints, false);
        }
        
        //Integer value domain: Hour
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newIntegerDomain("Hour", null, 0, 23, edma_constraints, false);
        }
        
        //Integer value domain: Minute
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newIntegerDomain("Minute", null, 0, 59, edma_constraints, false);
        }
        
        //Integer value domain: Second
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newIntegerDomain("Second", null, 0, 59, edma_constraints, false);
        }
        
        //Integer value domain: Millisecond
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newIntegerDomain("Millisecond", null, 0, 999, edma_constraints, false);
        }
        
        //Struct value domain: Time
        {
            ArrayList<Constraint> edma_constraints = null;
            Collection<Field> fields = new ArrayList<Field>();
            fields.add(vdb.newStructField("hour", "Hour", false));
            fields.add(vdb.newStructField("min", "Minute", false));
            fields.add(vdb.newStructField("second", "Second", false));
            fields.add(vdb.newStructField("milliseconds", "Millisecond", false));
            vdb.newStructDomain("Time", null, fields, edma_constraints, false);
        }
        
        //Struct value domain: DateAndTime
        {
            ArrayList<Constraint> edma_constraints = null;
            Collection<Field> fields = new ArrayList<Field>();
            fields.add(vdb.newStructField("date", "Date", false));
            fields.add(vdb.newStructField("time", "Time", false));
            vdb.newStructDomain("DateAndTime", null, fields, edma_constraints, false);
        }
        
        //String value domain: Name
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newStringDomain("Name", null, 1, null, null, edma_constraints, false);
        }
        
        //String value domain: Email
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newStringDomain("Email", null, 3, null, "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", edma_constraints, false);
        }
        
        //String value domain: Mobile
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newStringDomain("Mobile", null, 8, 8, "[0-9]+", edma_constraints, false);
        }
        
        //String value domain: AddressLine
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newStringDomain("AddressLine", null, 1, null, null, edma_constraints, false);
        }
        
        //String value domain: City
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newStringDomain("City", null, 1, null, null, edma_constraints, false);
        }
        
        //Integer value domain: ZipCode
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newIntegerDomain("ZipCode", null, 1000, 9999, edma_constraints, false);
        }
        
        //Struct value domain: Address
        {
            ArrayList<Constraint> edma_constraints = null;
            Collection<Field> fields = new ArrayList<Field>();
            fields.add(vdb.newStructField("line1", "AddressLine", false));
            fields.add(vdb.newStructField("line2", "AddressLine", true));
            fields.add(vdb.newStructField("city", "City", false));
            fields.add(vdb.newStructField("zipCode", "ZipCode", false));
            vdb.newStructDomain("Address", null, fields, edma_constraints, false);
        }
        
        //Integer value domain: AnyInt
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newIntegerDomain("AnyInt", null, null, null, edma_constraints, false);
        }
        
        //Integer value domain: PosInt
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newIntegerDomain("PosInt", null, 1, null, edma_constraints, false);
        }
        
        //Integer value domain: NotNegInt
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newIntegerDomain("NotNegInt", null, 0, null, edma_constraints, false);
        }
        
        //String value domain: AnyString
        {
            ArrayList<Constraint> edma_constraints = null;
            vdb.newStringDomain("AnyString", null, null, null, null, edma_constraints, false);
        }
        MetaEnvironment edma_environment = new MetaEnvironment("EDMADataModels");
        {
            MetaDataModel edma_model = new MetaDataModel("MyDataModel", "EDMADataModels");
        
            // Kind : Person
            MetaKind person = new MetaKind("Person", null, null);
            {
                new MetaAttribute(person, "firstName", "Name", false, true, null);
                new MetaAttribute(person, "lastName", "Name", false, true, null);
                new MetaAttribute(person, "email", "Email", false, true, null);
                //Index:  Unique (email)
                {
                    MetaIndex edma_index = new MetaIndex(IndexType.Unique);
                    edma_index.addAttribute(person.getAttribute(2));
                    person.addIndex(edma_index);
                }
            }
            edma_model.addKind(person);
        
            // Kind : Course
            MetaKind course = new MetaKind("Course", null, null);
            {
                new MetaAttribute(course, "name", "Name", false, false, null);
                //Index:  Unique (name)
                {
                    MetaIndex edma_index = new MetaIndex(IndexType.Unique);
                    edma_index.addAttribute(course.getAttribute(0));
                    course.addIndex(edma_index);
                }
            }
            edma_model.addKind(course);
        
            //Relations:
            {
                MetaRelation mr = new MetaRelation("CourseEnrollment", course, "course", person, "student", RelationType.ManyToMany);
                edma_model.addRelation(mr);
            }
            {
                MetaRelation mr = new MetaRelation("TeacherAssignment", course, "course", person, "teacher", RelationType.ManyToOne);
                edma_model.addRelation(mr);
            }
        
            //Views:
            {
                MetaMethod view = new MetaMethod("getCourseStudent", "Get all Students from a Course");
                view.addInputParameter("courseID", "CourseID", false);
                view.addOutputParameter("studentList", "PersonList", false);
                edma_model.addView(view);
            }
            {
                MetaMethod view = new MetaMethod("getCourseTeacher", "Get Teacher from a Course");
                view.addInputParameter("courseID", "CourseID", false);
                view.addOutputParameter("teacher", "Person", true);
                edma_model.addView(view);
            }
            {
                MetaMethod view = new MetaMethod("getAllPersons", "Get all Persons");
                view.addOutputParameter("personList", "PersonList", false);
                edma_model.addView(view);
            }
        
            //Actions:
            {
                MetaMethod action = new MetaMethod("createPerson", "Creates a new Person");
                action.addInputParameter("firstName", "Name", false);
                action.addInputParameter("lastName", "Name", false);
                action.addInputParameter("email", "Email", false);
                action.addOutputParameter("id", "PersonID", false);
                edma_model.addAction(action);
            }
            {
                MetaMethod action = new MetaMethod("createCourse", "Creates a new Course");
                action.addInputParameter("name", "Name", false);
                action.addOutputParameter("id", "CourseID", false);
                edma_model.addAction(action);
            }
            {
                MetaMethod action = new MetaMethod("assignStudentToCourse", "Assign a Student to a Course");
                action.addInputParameter("studentID", "PersonID", false);
                action.addInputParameter("courseID", "CourseID", false);
                edma_model.addAction(action);
            }
            {
                MetaMethod action = new MetaMethod("assignTeacherToCourse", "Assign a Teacher to a Course");
                action.addInputParameter("teacherID", "PersonID", false);
                action.addInputParameter("courseID", "CourseID", false);
                edma_model.addAction(action);
            }
            edma_environment.addMetaDataModel(edma_model);
        }
        vdb.buildWithEnvironment(edma_environment);
        //Hack to make serializeable work...
        IndexUtil.setValueDomainDefinitions(edma_environment.getValueDomainDefinitions());
        return edma_environment;
    }

    /**
     * Constructor
     * @param factory  The runtime factory
     */
    public EDMADataModels(IRuntimeFactory factory)
    {
        edma_MyDataModel = new MyDataModelFactoryImpl(factory.getDataModelInstanceFactory(environment.getMetaDataModel(0)));
    }

    /**
     * Get access to the MyDataModel data model factory
     * @return  The MyDataModel data model storage
     */
    public MyDataModelFactoryImpl getMyDataModelFactory()
    {
        return edma_MyDataModel;
    }
}
