package com.jezdevcode.hymnairelldm.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile HymnDao _hymnDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `hymns` (`hymnNumber` INTEGER NOT NULL, `hymnFrenchTitle` TEXT NOT NULL, `hymnSpanishTitle` TEXT NOT NULL, `hymnTematic` TEXT NOT NULL, `hymnVerse` TEXT NOT NULL, `hymnChorus` TEXT NOT NULL, `favoriteHymn` INTEGER NOT NULL, PRIMARY KEY(`hymnNumber`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'bf764d7d9405681299826785e2d65fdd')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `hymns`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsHymns = new HashMap<String, TableInfo.Column>(7);
        _columnsHymns.put("hymnNumber", new TableInfo.Column("hymnNumber", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHymns.put("hymnFrenchTitle", new TableInfo.Column("hymnFrenchTitle", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHymns.put("hymnSpanishTitle", new TableInfo.Column("hymnSpanishTitle", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHymns.put("hymnTematic", new TableInfo.Column("hymnTematic", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHymns.put("hymnVerse", new TableInfo.Column("hymnVerse", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHymns.put("hymnChorus", new TableInfo.Column("hymnChorus", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHymns.put("favoriteHymn", new TableInfo.Column("favoriteHymn", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysHymns = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesHymns = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoHymns = new TableInfo("hymns", _columnsHymns, _foreignKeysHymns, _indicesHymns);
        final TableInfo _existingHymns = TableInfo.read(db, "hymns");
        if (!_infoHymns.equals(_existingHymns)) {
          return new RoomOpenHelper.ValidationResult(false, "hymns(com.jezdevcode.hymnairelldm.database.Hymn).\n"
                  + " Expected:\n" + _infoHymns + "\n"
                  + " Found:\n" + _existingHymns);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "bf764d7d9405681299826785e2d65fdd", "aaf2df9799585292a464c079654f4b09");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "hymns");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `hymns`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(HymnDao.class, HymnDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public HymnDao hymnDao() {
    if (_hymnDao != null) {
      return _hymnDao;
    } else {
      synchronized(this) {
        if(_hymnDao == null) {
          _hymnDao = new HymnDao_Impl(this);
        }
        return _hymnDao;
      }
    }
  }
}
