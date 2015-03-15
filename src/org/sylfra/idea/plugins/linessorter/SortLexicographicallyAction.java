package org.sylfra.idea.plugins.linessorter;

import com.intellij.openapi.editor.actions.TextComponentEditorAction;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Dumb action to perform sort
 *
 * @author <a href="mailto:syllant@gmail.com">Sylvain FRANCOIS</a>
 * @version $Id$
 */
public class SortLexicographicallyAction extends TextComponentEditorAction
{
    protected SortLexicographicallyAction()
    {
        super(new SortHandler(new SortLexicographically()));
    }

    private static class SortLexicographically implements SortHandler.Sorter {

        private static final Comparator<String> LEXICOGRAPHIC_COMPARE = new LexicographicCompare();

        private static class LexicographicCompare implements Comparator<String>
        {
            public int compare(String s1, String s2)
            {
                return s1.compareToIgnoreCase(s2);
            }
        }

        public void sort(List<String> lines)
        {
            Collections.sort(lines, LEXICOGRAPHIC_COMPARE);
        }

    }

}