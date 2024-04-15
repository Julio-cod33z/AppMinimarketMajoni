package pe.edu.idat.appminimarketmajoni.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pe.edu.idat.appminimarketmajoni.model.db.dao.ProductoDao
import pe.edu.idat.appminimarketmajoni.model.db.entity.Producto

@Database(entities = [Producto::class], version = 1)
public abstract class MajoniRoomDatabase: RoomDatabase() {
    abstract fun productoDao(): ProductoDao

    companion object {
        @Volatile
        private var Instancia: MajoniRoomDatabase? = null
        fun getDatabase(context: Context): MajoniRoomDatabase {
            val tempInstancia = Instancia
            if(tempInstancia != null) {
                return tempInstancia
            }
            synchronized(this) {
                val instancia = Room.databaseBuilder(context.applicationContext,
                    MajoniRoomDatabase::class.java, "minimarketmajonidb").build()
                Instancia = instancia
                return instancia
            }
        }
    }
}