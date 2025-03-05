package entity;

public class Class {
    public int classId;
    public String className;
    public int teacherId;

    public Class(int classId, String className, int teacherId) {
        this.classId = classId;
        this.className = className;
        this.teacherId = teacherId;
    }

    public Class(int classId) {
        this.classId = classId;
    }

    public Class(){}

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
