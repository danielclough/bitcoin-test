/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002, 2019 Oracle and/or its affiliates.  All rights reserved.
 *
 */

package com.sleepycat.client.persist;

import java.io.Closeable;
import java.util.Iterator;

import com.sleepycat.client.SDatabaseException;
import com.sleepycat.client.SLockMode;

/**
 * Cursor operations limited to traversing forward.  See {@link EntityCursor}
 * for general information on cursors.
 *
 * <p>{@code ForwardCursor} objects are <em>not</em> thread-safe.  Cursors
 * should be opened, used and closed by a single thread.</p>
 *
 * <p><em>WARNING:</em> Cursors must always be closed to prevent resource leaks
 * which could lead to the index becoming unusable or cause an
 * <code>OutOfMemoryError</code>.  To ensure that a cursor is closed in the
 * face of exceptions, close it in a finally block.</p>
 *
 * @author Mark Hayes
 */
public interface ForwardCursor<V> extends Iterable<V>
    {

    /**
     * Moves the cursor to the next value and returns it, or returns null
     * if there are no more values in the cursor range.  If the cursor is
     * uninitialized, this method returns the first value.
     *
     * <p>{@link SLockMode#DEFAULT} is used implicitly.</p>
     *
     * @return the next value, or null if there are no more values in the
     * cursor range.
     *
     *
     * @throws SDatabaseException the base class for all BDB exceptions.
     */
    V next()
        throws SDatabaseException;

    /**
     * Moves the cursor to the next value and returns it, or returns null
     * if there are no more values in the cursor range.  If the cursor is
     * uninitialized, this method returns the first value.
     *
     * @param lockMode the lock mode to use for this operation, or null to
     * use {@link SLockMode#DEFAULT}.
     *
     * @return the next value, or null if there are no more values in the
     * cursor range.
     *
     *
     * @throws SDatabaseException the base class for all BDB exceptions.
     */
    V next(SLockMode lockMode)
        throws SDatabaseException;

    /**
     * Returns an iterator over the key range, starting with the value
     * following the current position or at the first value if the cursor is
     * uninitialized.
     *
     * <p>{@link SLockMode#DEFAULT} is used implicitly.</p>
     *
     * @return the iterator.
     */
    Iterator<V> iterator();

    /**
     * Returns an iterator over the key range, starting with the value
     * following the current position or at the first value if the cursor is
     * uninitialized.
     *
     * @param lockMode the lock mode to use for all operations performed
     * using the iterator, or null to use {@link SLockMode#DEFAULT}.
     *
     * @return the iterator.
     */
    Iterator<V> iterator(SLockMode lockMode);

    /**
     * Closes the cursor.
     *
     * @throws SDatabaseException the base class for all BDB exceptions.
     */
    void close()
        throws SDatabaseException;
}
