package com.example.gestion_empleados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBaseEmpleados extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Empleados.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "empleado";
    private static final String COLUM_ID = "_id";
    private static final String COLUM_APELLIDOS = "apellidos";
    private static final String COLUM_DEPARTAMENTO = "departamento";
    private static final String COLUM_SALARIO = "salario";

    public static final String[] LISTA_DEPARTAMENTOS ={"RRHH", "Marketing", "Comercial", "Logística", "Dirección",
            "Operario", "Otro"};

    public DataBaseEmpleados(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME
                + " (" + COLUM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUM_APELLIDOS + " TEXT, "
                + COLUM_DEPARTAMENTO + " TEXT, "
                + COLUM_SALARIO + " NUMERIC);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    boolean addEmpleado(String apellido, String departamento, double salario) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUM_APELLIDOS, apellido);
        cv.put(COLUM_DEPARTAMENTO, departamento);
        cv.put(COLUM_SALARIO, salario);
        long result = db.insert(TABLE_NAME, null, cv);
        
        return result != -1;
    }

    Cursor getAllEmpleados() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null) {
            cursor = db.rawQuery(query, null);
        }

        return cursor;
    }
    Empleado getEmpleado(int id) {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUM_ID + " = " + id;
        SQLiteDatabase db = this.getReadableDatabase();

        Empleado empleado = null;
        Cursor cursor = null;
        if(db != null) {
            cursor = db.rawQuery(query, null);
            if(cursor.moveToNext()) {
                empleado = new Empleado(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getDouble(3));
            }

        }
        return empleado;
    }

    boolean modificarEmpleado(Empleado empleado) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUM_APELLIDOS, empleado.getApellido());
        cv.put(COLUM_DEPARTAMENTO, empleado.getDepartamento());
        cv.put(COLUM_SALARIO, empleado.getSalario());

        long result = db.update(TABLE_NAME, cv, COLUM_ID + " = " + empleado.getId(), null);
        return result != -1;
    }

    boolean eliminarEmpleado(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, COLUM_ID + " = " + id, null);
        return result != -1;
    }

}
