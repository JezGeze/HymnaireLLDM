package com.jezdevcode.hymnairelldm.database;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class HymnDao_Impl implements HymnDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Hymn> __insertionAdapterOfHymn;

  private final EntityDeletionOrUpdateAdapter<Hymn> __deletionAdapterOfHymn;

  private final EntityDeletionOrUpdateAdapter<Hymn> __updateAdapterOfHymn;

  public HymnDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfHymn = new EntityInsertionAdapter<Hymn>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `hymns` (`hymnNumber`,`hymnFrenchTitle`,`hymnSpanishTitle`,`hymnTematic`,`hymnVerse`,`hymnChorus`,`favoriteHymn`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Hymn entity) {
        statement.bindLong(1, entity.getHymnNumber());
        statement.bindString(2, entity.getHymnFrenchTitle());
        statement.bindString(3, entity.getHymnSpanishTitle());
        statement.bindString(4, entity.getHymnTematic());
        statement.bindString(5, entity.getHymnVerse());
        statement.bindString(6, entity.getHymnChorus());
        final int _tmp = entity.getFavoriteHymn() ? 1 : 0;
        statement.bindLong(7, _tmp);
      }
    };
    this.__deletionAdapterOfHymn = new EntityDeletionOrUpdateAdapter<Hymn>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `hymns` WHERE `hymnNumber` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Hymn entity) {
        statement.bindLong(1, entity.getHymnNumber());
      }
    };
    this.__updateAdapterOfHymn = new EntityDeletionOrUpdateAdapter<Hymn>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `hymns` SET `hymnNumber` = ?,`hymnFrenchTitle` = ?,`hymnSpanishTitle` = ?,`hymnTematic` = ?,`hymnVerse` = ?,`hymnChorus` = ?,`favoriteHymn` = ? WHERE `hymnNumber` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Hymn entity) {
        statement.bindLong(1, entity.getHymnNumber());
        statement.bindString(2, entity.getHymnFrenchTitle());
        statement.bindString(3, entity.getHymnSpanishTitle());
        statement.bindString(4, entity.getHymnTematic());
        statement.bindString(5, entity.getHymnVerse());
        statement.bindString(6, entity.getHymnChorus());
        final int _tmp = entity.getFavoriteHymn() ? 1 : 0;
        statement.bindLong(7, _tmp);
        statement.bindLong(8, entity.getHymnNumber());
      }
    };
  }

  @Override
  public Object insertHymn(final Hymn hymn, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfHymn.insert(hymn);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertAllHymns(final List<Hymn> hymnList,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfHymn.insert(hymnList);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Hymn hymn, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfHymn.handle(hymn);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateHymn(final Hymn hymn, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfHymn.handle(hymn);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Hymn>> getAll() {
    final String _sql = "SELECT * FROM hymns";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"hymns"}, new Callable<List<Hymn>>() {
      @Override
      @NonNull
      public List<Hymn> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfHymnNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "hymnNumber");
          final int _cursorIndexOfHymnFrenchTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "hymnFrenchTitle");
          final int _cursorIndexOfHymnSpanishTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "hymnSpanishTitle");
          final int _cursorIndexOfHymnTematic = CursorUtil.getColumnIndexOrThrow(_cursor, "hymnTematic");
          final int _cursorIndexOfHymnVerse = CursorUtil.getColumnIndexOrThrow(_cursor, "hymnVerse");
          final int _cursorIndexOfHymnChorus = CursorUtil.getColumnIndexOrThrow(_cursor, "hymnChorus");
          final int _cursorIndexOfFavoriteHymn = CursorUtil.getColumnIndexOrThrow(_cursor, "favoriteHymn");
          final List<Hymn> _result = new ArrayList<Hymn>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Hymn _item;
            final int _tmpHymnNumber;
            _tmpHymnNumber = _cursor.getInt(_cursorIndexOfHymnNumber);
            final String _tmpHymnFrenchTitle;
            _tmpHymnFrenchTitle = _cursor.getString(_cursorIndexOfHymnFrenchTitle);
            final String _tmpHymnSpanishTitle;
            _tmpHymnSpanishTitle = _cursor.getString(_cursorIndexOfHymnSpanishTitle);
            final String _tmpHymnTematic;
            _tmpHymnTematic = _cursor.getString(_cursorIndexOfHymnTematic);
            final String _tmpHymnVerse;
            _tmpHymnVerse = _cursor.getString(_cursorIndexOfHymnVerse);
            final String _tmpHymnChorus;
            _tmpHymnChorus = _cursor.getString(_cursorIndexOfHymnChorus);
            final boolean _tmpFavoriteHymn;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfFavoriteHymn);
            _tmpFavoriteHymn = _tmp != 0;
            _item = new Hymn(_tmpHymnNumber,_tmpHymnFrenchTitle,_tmpHymnSpanishTitle,_tmpHymnTematic,_tmpHymnVerse,_tmpHymnChorus,_tmpFavoriteHymn);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
