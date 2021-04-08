package main.generated.mydatamodel.remote;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import main.generated.mydatamodel.MyDataModel;
import main.generated.mydatamodel.actions.AssignStudentToCourseResult;
import main.generated.mydatamodel.actions.AssignTeacherToCourseResult;
import main.generated.mydatamodel.actions.CreateCourseResult;
import main.generated.mydatamodel.actions.CreatePersonResult;
import main.generated.mydatamodel.views.GetAllPersonsResult;
import main.generated.mydatamodel.views.GetCourseStudentResult;
import main.generated.mydatamodel.views.GetCourseTeacherResult;
import main.generated.valuedomains.Email;
import main.generated.valuedomains.Name;
import main.generated.valuedomains.mydatamodel.CourseID;
import main.generated.valuedomains.mydatamodel.Person;
import main.generated.valuedomains.mydatamodel.PersonID;
import main.generated.valuedomains.mydatamodel.PersonList;

/**
 * 
 */
public class MyDataModelClientInstance implements MyDataModel
{
    private String edma_hostname;
    private int edma_port;



    /**
     * Constructor
     * @param edma_hostname  Name of the server host
     * @param edma_port      port to connect to
     */
    public MyDataModelClientInstance(String edma_hostname, int edma_port)
    {
        this.edma_hostname = edma_hostname;
        this.edma_port = edma_port;
    }

    /**
     * Get all Students from a Course
     * @param courseID  Input parameter courseID
     * @return          
     */
    public GetCourseStudentResult getCourseStudent(CourseID courseID) throws IOException
    {
        if(courseID == null)
        {
            throw new NullPointerException("courseID may not be null");
        }
        Socket edma_socket = new Socket(edma_hostname, edma_port);
        BufferedInputStream buf_in = new BufferedInputStream(edma_socket.getInputStream());
        DataInput edma_in = new DataInputStream(buf_in);
        BufferedOutputStream buf_out = new BufferedOutputStream(edma_socket.getOutputStream());
        DataOutput edma_out = new DataOutputStream(buf_out);
        edma_out.writeInt(0);
        courseID.toStream(edma_out);
        buf_out.flush();
        if(!edma_in.readBoolean())
        {
            String edma_error = edma_in.readUTF();
            buf_out.close();
            buf_in.close();
            edma_socket.close();
            throw new IOException(edma_error);
        }
        int errorCode = edma_in.readInt();
        String errorMsg = edma_in.readUTF();
        String errorDesc = null;
        if(edma_in.readBoolean())
        {
            errorDesc = edma_in.readUTF();
        }
        PersonList out_studentList = PersonList.fromStreamNoValidate(edma_in);
        buf_out.close();
        buf_in.close();
        edma_socket.close();
        return new RemoteGetCourseStudentResult(errorCode, errorMsg, errorDesc, out_studentList);
    }

    /**
     * Get Teacher from a Course
     * @param courseID  Input parameter courseID
     * @return          
     */
    public GetCourseTeacherResult getCourseTeacher(CourseID courseID) throws IOException
    {
        if(courseID == null)
        {
            throw new NullPointerException("courseID may not be null");
        }
        Socket edma_socket = new Socket(edma_hostname, edma_port);
        BufferedInputStream buf_in = new BufferedInputStream(edma_socket.getInputStream());
        DataInput edma_in = new DataInputStream(buf_in);
        BufferedOutputStream buf_out = new BufferedOutputStream(edma_socket.getOutputStream());
        DataOutput edma_out = new DataOutputStream(buf_out);
        edma_out.writeInt(1);
        courseID.toStream(edma_out);
        buf_out.flush();
        if(!edma_in.readBoolean())
        {
            String edma_error = edma_in.readUTF();
            buf_out.close();
            buf_in.close();
            edma_socket.close();
            throw new IOException(edma_error);
        }
        int errorCode = edma_in.readInt();
        String errorMsg = edma_in.readUTF();
        String errorDesc = null;
        if(edma_in.readBoolean())
        {
            errorDesc = edma_in.readUTF();
        }
        Person out_teacher = null;
        if(edma_in.readBoolean()) out_teacher = Person.fromStreamNoValidate(edma_in);
        buf_out.close();
        buf_in.close();
        edma_socket.close();
        return new RemoteGetCourseTeacherResult(errorCode, errorMsg, errorDesc, out_teacher);
    }

    /**
     * Get all Persons
     * @return  
     */
    public GetAllPersonsResult getAllPersons() throws IOException
    {
        Socket edma_socket = new Socket(edma_hostname, edma_port);
        BufferedInputStream buf_in = new BufferedInputStream(edma_socket.getInputStream());
        DataInput edma_in = new DataInputStream(buf_in);
        BufferedOutputStream buf_out = new BufferedOutputStream(edma_socket.getOutputStream());
        DataOutput edma_out = new DataOutputStream(buf_out);
        edma_out.writeInt(2);
        buf_out.flush();
        if(!edma_in.readBoolean())
        {
            String edma_error = edma_in.readUTF();
            buf_out.close();
            buf_in.close();
            edma_socket.close();
            throw new IOException(edma_error);
        }
        int errorCode = edma_in.readInt();
        String errorMsg = edma_in.readUTF();
        String errorDesc = null;
        if(edma_in.readBoolean())
        {
            errorDesc = edma_in.readUTF();
        }
        PersonList out_personList = PersonList.fromStreamNoValidate(edma_in);
        buf_out.close();
        buf_in.close();
        edma_socket.close();
        return new RemoteGetAllPersonsResult(errorCode, errorMsg, errorDesc, out_personList);
    }

    /**
     * Creates a new Person
     * @param firstName  Input parameter firstName
     * @param lastName   Input parameter lastName
     * @param email      Input parameter email
     * @return           
     */
    public CreatePersonResult createPerson(Name firstName, Name lastName, Email email) throws IOException
    {
        if(firstName == null)
        {
            throw new NullPointerException("firstName may not be null");
        }
        if(lastName == null)
        {
            throw new NullPointerException("lastName may not be null");
        }
        if(email == null)
        {
            throw new NullPointerException("email may not be null");
        }
        Socket edma_socket = new Socket(edma_hostname, edma_port);
        BufferedInputStream buf_in = new BufferedInputStream(edma_socket.getInputStream());
        DataInput edma_in = new DataInputStream(buf_in);
        BufferedOutputStream buf_out = new BufferedOutputStream(edma_socket.getOutputStream());
        DataOutput edma_out = new DataOutputStream(buf_out);
        edma_out.writeInt(3);
        firstName.toStream(edma_out);
        lastName.toStream(edma_out);
        email.toStream(edma_out);
        buf_out.flush();
        if(!edma_in.readBoolean())
        {
            String edma_error = edma_in.readUTF();
            buf_out.close();
            buf_in.close();
            edma_socket.close();
            throw new IOException(edma_error);
        }
        int errorCode = edma_in.readInt();
        String errorMsg = edma_in.readUTF();
        String errorDesc = null;
        if(edma_in.readBoolean())
        {
            errorDesc = edma_in.readUTF();
        }
        PersonID out_id = PersonID.fromStreamNoValidate(edma_in);
        buf_out.close();
        buf_in.close();
        edma_socket.close();
        return new RemoteCreatePersonResult(errorCode, errorMsg, errorDesc, out_id);
    }

    /**
     * Creates a new Course
     * @param name  Input parameter name
     * @return      
     */
    public CreateCourseResult createCourse(Name name) throws IOException
    {
        if(name == null)
        {
            throw new NullPointerException("name may not be null");
        }
        Socket edma_socket = new Socket(edma_hostname, edma_port);
        BufferedInputStream buf_in = new BufferedInputStream(edma_socket.getInputStream());
        DataInput edma_in = new DataInputStream(buf_in);
        BufferedOutputStream buf_out = new BufferedOutputStream(edma_socket.getOutputStream());
        DataOutput edma_out = new DataOutputStream(buf_out);
        edma_out.writeInt(4);
        name.toStream(edma_out);
        buf_out.flush();
        if(!edma_in.readBoolean())
        {
            String edma_error = edma_in.readUTF();
            buf_out.close();
            buf_in.close();
            edma_socket.close();
            throw new IOException(edma_error);
        }
        int errorCode = edma_in.readInt();
        String errorMsg = edma_in.readUTF();
        String errorDesc = null;
        if(edma_in.readBoolean())
        {
            errorDesc = edma_in.readUTF();
        }
        CourseID out_id = CourseID.fromStreamNoValidate(edma_in);
        buf_out.close();
        buf_in.close();
        edma_socket.close();
        return new RemoteCreateCourseResult(errorCode, errorMsg, errorDesc, out_id);
    }

    /**
     * Assign a Student to a Course
     * @param studentID  Input parameter studentID
     * @param courseID   Input parameter courseID
     * @return           
     */
    public AssignStudentToCourseResult assignStudentToCourse(PersonID studentID, CourseID courseID) throws IOException
    {
        if(studentID == null)
        {
            throw new NullPointerException("studentID may not be null");
        }
        if(courseID == null)
        {
            throw new NullPointerException("courseID may not be null");
        }
        Socket edma_socket = new Socket(edma_hostname, edma_port);
        BufferedInputStream buf_in = new BufferedInputStream(edma_socket.getInputStream());
        DataInput edma_in = new DataInputStream(buf_in);
        BufferedOutputStream buf_out = new BufferedOutputStream(edma_socket.getOutputStream());
        DataOutput edma_out = new DataOutputStream(buf_out);
        edma_out.writeInt(5);
        studentID.toStream(edma_out);
        courseID.toStream(edma_out);
        buf_out.flush();
        if(!edma_in.readBoolean())
        {
            String edma_error = edma_in.readUTF();
            buf_out.close();
            buf_in.close();
            edma_socket.close();
            throw new IOException(edma_error);
        }
        int errorCode = edma_in.readInt();
        String errorMsg = edma_in.readUTF();
        String errorDesc = null;
        if(edma_in.readBoolean())
        {
            errorDesc = edma_in.readUTF();
        }
        buf_out.close();
        buf_in.close();
        edma_socket.close();
        return new RemoteAssignStudentToCourseResult(errorCode, errorMsg, errorDesc);
    }

    /**
     * Assign a Teacher to a Course
     * @param teacherID  Input parameter teacherID
     * @param courseID   Input parameter courseID
     * @return           
     */
    public AssignTeacherToCourseResult assignTeacherToCourse(PersonID teacherID, CourseID courseID) throws IOException
    {
        if(teacherID == null)
        {
            throw new NullPointerException("teacherID may not be null");
        }
        if(courseID == null)
        {
            throw new NullPointerException("courseID may not be null");
        }
        Socket edma_socket = new Socket(edma_hostname, edma_port);
        BufferedInputStream buf_in = new BufferedInputStream(edma_socket.getInputStream());
        DataInput edma_in = new DataInputStream(buf_in);
        BufferedOutputStream buf_out = new BufferedOutputStream(edma_socket.getOutputStream());
        DataOutput edma_out = new DataOutputStream(buf_out);
        edma_out.writeInt(6);
        teacherID.toStream(edma_out);
        courseID.toStream(edma_out);
        buf_out.flush();
        if(!edma_in.readBoolean())
        {
            String edma_error = edma_in.readUTF();
            buf_out.close();
            buf_in.close();
            edma_socket.close();
            throw new IOException(edma_error);
        }
        int errorCode = edma_in.readInt();
        String errorMsg = edma_in.readUTF();
        String errorDesc = null;
        if(edma_in.readBoolean())
        {
            errorDesc = edma_in.readUTF();
        }
        buf_out.close();
        buf_in.close();
        edma_socket.close();
        return new RemoteAssignTeacherToCourseResult(errorCode, errorMsg, errorDesc);
    }
}
