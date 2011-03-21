/**
 * Copyright (c) 2003, www.pdfbox.org
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 3. Neither the name of pdfbox; nor the names of its
 *    contributors may be used to endorse or promote products derived from this
 *    software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE REGENTS OR CONTRIBUTORS BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * http://www.pdfbox.org
 *
 */
package org.pdfbox.pdfwriter;

import org.pdfbox.persistence.util.COSObjectKey;

import org.pdfbox.cos.COSBase;

/**
 * this is en entry in the xref section of the physical pdf document
 * generated by the COSWriter.
 *
 * @author Michael Traut
 * @version $Revision$
 */
public class COSWriterXRefEntry implements Comparable
{
    private long offset;
    private COSBase object;
    private COSObjectKey key;
    private boolean free = false;



    /**
     * @see Comparable#compareTo( Object )
     */
    public int compareTo(Object obj)
    {
        if (obj instanceof COSWriterXRefEntry)
        {
            return (int)(getKey().getNumber() - ((COSWriterXRefEntry)obj).getKey().getNumber());
        }
        else
        {
            return -1;
        }
    }
    /**
     * This will get the Object key.
     *
     * @return The object key.
     */
    public COSObjectKey  getKey()
    {
        return key;
    }



    /**
     * This will get the offset into the document.
     *
     * @return The offset into the document.
     */
    public long getOffset()
    {
        return offset;
    }

    /**
     * Gets the xref 'free' attribute.
     *
     * @return The free attribute.
     */
    public boolean isFree()
    {
        return free;
    }

    /**
     * This will set the free attribute.
     *
     * @param newFree The newly freed attribute.
     */
    public void setFree(boolean newFree)
    {
        free = newFree;
    }

    /**
     * This will set the object key.
     *
     * @param newKey The new object key.
     */
    private void setKey(COSObjectKey  newKey)
    {
        key = newKey;
    }



    /**
     * The offset attribute.
     *
     * @param newOffset The new value for the offset.
     */
    public void setOffset(long newOffset)
    {
        offset = newOffset;
    }

    /**
     * COSWriterXRefEntry constructor comment.
     *
     * @param start The start attribute.
     * @param obj The COS object that this entry represents.
     * @param keyValue The key to the COS object.
     */
    public COSWriterXRefEntry(long start, COSBase obj, COSObjectKey keyValue)
    {
        super();
        setOffset(start);
        setObject(obj);
        setKey(keyValue);
    }

    /**
     * This will get the object.
     *
     * @return The object.
     */
    public COSBase getObject()
    {
        return object;
    }

    /**
     * This will set the object for this xref.
     *
     * @param newObject The object that is being set.
     */
    private void setObject(COSBase newObject)
    {
        object = newObject;
    }
}