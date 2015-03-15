package org.sylfra.idea.plugins.linessorter;

import com.intellij.openapi.editor.actions.TextComponentEditorAction;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByLengthAction extends TextComponentEditorAction {

    protected SortByLengthAction()
    {
        super(new SortHandler(new SortAlphabetically()));
    }

    private static class SortAlphabetically implements SortHandler.Sorter {

        private static final Comparator<String> COMPARATOR_BY_SIZE = new ComparatorByAscendingSize();

        private static class ComparatorByAscendingSize implements Comparator<String>
        {
            public int compare(String s1, String s2)
            {
                return s2.length() - s1.length();
            }
        }

        public void sort(List<String> lines)
        {
            Collections.sort(lines, COMPARATOR_BY_SIZE);
        }

    }

}
