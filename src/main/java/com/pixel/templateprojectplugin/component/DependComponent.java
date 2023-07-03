package com.pixel.templateprojectplugin.component;

import com.intellij.ui.JBColor;
import com.intellij.ui.components.JBScrollPane;
import com.pixel.templateprojectplugin.domain.model.DependInfoModel;
import org.jdesktop.swingx.JXComboBox;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:
 *
 * @author lixin
 */
public class DependComponent extends JFrame {

    private final JPanel mainPanel;

    private JPanel rightPanel;

    private JXComboBox jxComboBox;

    private final Map<String, String> dependMap = new HashMap<>();

    private final Map<String, JLabel> jLabelMap = new HashMap<>();

    private final java.util.List<DependInfoModel> list = DependInfoModel.initList;

    public DependComponent() {
        mainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        init();
    }

    public void init() {
        addRow1();
        addRow2();
        addRow3();
    }

    private void addRow1() {
        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jPanel.add(new JLabel("Pixel-base Version"));
        jxComboBox = new JXComboBox(new String[]{"1.0.2", "1.0.4"});
        jxComboBox.setSelectedItem("1.0.2");
        jPanel.add(jxComboBox);
        jPanel.setPreferredSize(new Dimension(780, 50));
        mainPanel.add(jPanel);
    }

    private void addRow2() {
        JPanel jPanel = new JPanel(new GridLayout(1, 2));
        jPanel.add(new JLabel("Dependencies"));
        jPanel.add(new JLabel("Added Dependencies"));
        jPanel.setPreferredSize(new Dimension(780, 30));
        mainPanel.add(jPanel);
    }

    private void addRow3() {
        JPanel jPanel = new JPanel(new GridLayout(1, 2));

        Border emptyBorder = BorderFactory.createEmptyBorder(5, 15, 5, 15);
        Border lineBorder = BorderFactory.createLineBorder(JBColor.BLACK, 1);
        Border compoundBorder = BorderFactory.createCompoundBorder(lineBorder, emptyBorder);

        JPanel leftPanel = new JPanel(new GridLayout(15, 0));
        leftPanel.setPreferredSize(new Dimension(390, 400));
        leftPanel.setBorder(compoundBorder);

        JScrollPane leftScrollPane = new JBScrollPane(leftPanel);
        leftScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        for (DependInfoModel dependInfoModel : list) {
            JCheckBox jCheckBox = new JCheckBox(dependInfoModel.getName());
            jCheckBox.setName(dependInfoModel.getKey());
            jCheckBox.addItemListener(createItemListener());
            leftPanel.add(jCheckBox);
        }

        jPanel.add(leftScrollPane);

        rightPanel = new JPanel(new GridLayout(15,1));
        rightPanel.setPreferredSize(new Dimension(390, 400));
        rightPanel.setBorder(compoundBorder);

        JScrollPane rightScrollPane = new JBScrollPane(rightPanel);
        rightScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel.add(rightScrollPane);

        jPanel.setPreferredSize(new Dimension(780, 400));
        mainPanel.add(jPanel);
    }

    public ItemListener createItemListener() {
        return e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                JCheckBox jCheckBox = (JCheckBox) e.getSource();
                String name = jCheckBox.getName();
                if (this.jLabelMap.containsKey(name)) {
                    this.rightPanel.add(this.jLabelMap.get(name));
                } else {
                    JLabel jLabel = new JLabel(jCheckBox.getName());
                    this.rightPanel.add(jLabel);
                    this.jLabelMap.put(name, jLabel);
                }
                this.dependMap.put(name, name);
                this.rightPanel.repaint();
                this.rightPanel.validate();
            } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                // Checkbox 取消选中时执行的操作
                JCheckBox jCheckBox = (JCheckBox) e.getSource();
                this.rightPanel.remove(this.jLabelMap.get(jCheckBox.getName()));
                this.dependMap.remove(jCheckBox.getName());
                this.rightPanel.repaint();
                this.rightPanel.validate();
            }
        };
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JXComboBox getJxComboBox() {
        return jxComboBox;
    }

    public Map<String, String> getDependMap() {
        return dependMap;
    }

}
