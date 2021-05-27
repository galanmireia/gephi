/*
Copyright 2008-2010 Gephi
Authors : Mathieu Bastian <mathieu.bastian@gephi.org>
Website : http://www.gephi.org

This file is part of Gephi.

DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

Copyright 2011 Gephi Consortium. All rights reserved.

The contents of this file are subject to the terms of either the GNU
General Public License Version 3 only ("GPL") or the Common
Development and Distribution License("CDDL") (collectively, the
"License"). You may not use this file except in compliance with the
License. You can obtain a copy of the License at
http://gephi.org/about/legal/license-notice/
or /cddl-1.0.txt and /gpl-3.0.txt. See the License for the
specific language governing permissions and limitations under the
License.  When distributing the software, include this License Header
Notice in each file and include the License files at
/cddl-1.0.txt and /gpl-3.0.txt. If applicable, add the following below the
License Header, with the fields enclosed by brackets [] replaced by
your own identifying information:
"Portions Copyrighted [year] [name of copyright owner]"

If you wish your version of this file to be governed by only the CDDL
or only the GPL Version 3, indicate your decision by adding
"[Contributor] elects to include this software in this distribution
under the [CDDL or GPL Version 3] license." If you do not indicate a
single choice of license, a recipient has the option to distribute
your version of this file under either the CDDL, the GPL Version 3 or
to extend the choice of license to its licensees as provided above.
However, if you add GPL Version 3 code and therefore, elected the GPL
Version 3 license, then the option applies only if the new code is
made subject to such option by the copyright holder.

Contributor(s):

Portions Copyrighted 2011 Gephi Consortium.
 */
package org.gephi.ui.filters.plugin.attribute;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.gephi.filters.plugin.attribute.AttributeEqualBuilder.EqualBooleanFilter;
import org.gephi.filters.spi.FilterProperty;
import org.openide.util.Exceptions;

/**
 *
 * @author Mathieu Bastian
 */
public class EqualBooleanPanel extends javax.swing.JPanel implements ActionListener {

    private EqualBooleanFilter filter;

    public EqualBooleanPanel() {
        initComponents();
        trueButton.addActionListener(this);
        falseButton.addActionListener(this);
    }

    public void setup(EqualBooleanFilter filter) {
        this.filter = filter;
        this.setToolTipText(filter.getName() + " '" + filter.getColumn().getTitle() + "'");
        group.clearSelection();
        group.setSelected(trueButton.getModel(), filter.isMatch());
        group.setSelected(falseButton.getModel(), !filter.isMatch());
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        FilterProperty match = filter.getProperties()[1];
        try {
            match.setValue(trueButton.isSelected());
        } catch (Exception e) {
            Exceptions.printStackTrace(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        group = new javax.swing.ButtonGroup();
        trueButton = new javax.swing.JToggleButton();
        falseButton = new javax.swing.JToggleButton();

        setOpaque(false);

        group.add(trueButton);
        trueButton.setText(org.openide.util.NbBundle.getMessage(EqualBooleanPanel.class, "EqualBooleanPanel.trueButton.text")); // NOI18N
        add(trueButton);

        group.add(falseButton);
        falseButton.setText(org.openide.util.NbBundle.getMessage(EqualBooleanPanel.class, "EqualBooleanPanel.falseButton.text")); // NOI18N
        add(falseButton);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton falseButton;
    private javax.swing.ButtonGroup group;
    private javax.swing.JToggleButton trueButton;
    // End of variables declaration//GEN-END:variables
}
