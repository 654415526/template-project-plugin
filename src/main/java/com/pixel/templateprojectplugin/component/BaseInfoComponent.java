package com.pixel.templateprojectplugin.component;

import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.pixel.templateprojectplugin.domain.model.BaseInfoModel;
import org.jdesktop.swingx.JXComboBox;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.Objects;

/**
 * 功能描述:
 *
 * @author lixin
 */
public class BaseInfoComponent extends JFrame {

    private final JPanel gridPanel;

    public BaseInfoComponent() {

        gridPanel = new JPanel(new GridLayout(10, 3));

        for (BaseInfoModel baseInfoModel : BaseInfoModel.initList) {
            gridPanel.add(addRow(baseInfoModel));
        }

        gridPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JTextField nameTextField = (JTextField) getComponentByName(gridPanel.getComponents(), "name");
        JTextField artifactTextField = (JTextField) getComponentByName(gridPanel.getComponents(), "artifact");
        JTextField packageNameTextField = (JTextField) getComponentByName(gridPanel.getComponents(), "packageName");
        nameTextField.getDocument().addDocumentListener(createListener(nameTextField, artifactTextField, packageNameTextField));

        artifactTextField.setText(nameTextField.getText());
        packageNameTextField.setText(packageNameTextField.getText().concat(nameTextField.getText()));
    }

    public static Component getComponentByName(Component[] components, String name) {
        for (Component component : components) {
            if (component instanceof JPanel) {
                JPanel panel = (JPanel) component;
                for (Component c : panel.getComponents()) {
                    if (Objects.nonNull(c.getName()) && c.getName().equals(name)) {
                        return c;
                    }
                }
            }
        }
        throw new IllegalArgumentException("getComponentByName err...");
    }

    public Component addRow(BaseInfoModel baseInfoModel) {
        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        addLabel(baseInfoModel, jPanel);
        selector(baseInfoModel, jPanel);
        return jPanel;
    }

    public void selector(BaseInfoModel info, JPanel panel) {
        switch (info.getComponentTypeEnum()) {
            case INPUT:
                addInput(info, panel);
                break;
            case RADIO:
                addRadioGroup(info, panel);
                break;
            case COMBO_BOX:
                addComboBox(info, panel);
                break;
            case BUTTON:
                panel.add(new JButton());
                break;
            case FILE_INPUT:
                addFileInput(info, panel);
                break;
            default:
                throw new IllegalArgumentException("selector err...");
        }
    }

    private static void addLabel(BaseInfoModel baseInfoModel, JPanel jPanel) {
        JLabel jLabel = new JLabel(baseInfoModel.getName());
        jLabel.setPreferredSize(new Dimension(100, jLabel.getPreferredSize().height));
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jPanel.add(jLabel);
    }

    private static void addComboBox(BaseInfoModel info, JPanel panel) {
        JXComboBox jxComboBox;
        if (Objects.nonNull(info.getItems())) {
            jxComboBox = new JXComboBox(info.getItems().toArray());
            jxComboBox.setSelectedItem(StringUtil.isEmpty(info.getDefaultValue()) ? 0 : info.getDefaultValue());
        } else {
            jxComboBox = new JXComboBox();
        }
        jxComboBox.setName(info.getKey());
        panel.add(jxComboBox);
    }

    private static void addRadioGroup(BaseInfoModel info, JPanel panel) {
        ButtonGroup group = new ButtonGroup();
        for (String item : info.getItems()) {
            JRadioButton jRadioButton = new JRadioButton(item);
            if (item.equals(info.getDefaultValue())) {
                jRadioButton.setSelected(Boolean.TRUE);
            }
            if (info.getForbidden().contains(item)) {
                jRadioButton.setEnabled(Boolean.FALSE);
            }
            jRadioButton.setPreferredSize(new Dimension(90, jRadioButton.getPreferredSize().height));
            group.add(jRadioButton);
            panel.add(jRadioButton);
        }
    }

    private static void addInput(BaseInfoModel info, JPanel panel) {
        JTextField jTextField = new JTextField(info.getDefaultValue(), 42);
        jTextField.setName(info.getKey());
        panel.add(jTextField);
    }

    private void addFileInput(BaseInfoModel info, JPanel panel) {
        JTextField jTextField = new JTextField(info.getDefaultValue(), 33);
        jTextField.setName(info.getKey());
        panel.add(jTextField);

        JButton fileButton = new JButton("选择文件夹");
        fileButton.addActionListener(e -> jTextField.setText(openSystemFileChooser()));
        panel.add(fileButton);
    }

    private static String openSystemFileChooser() {
        FileChooserDescriptor descriptor = new FileChooserDescriptor(false, true, false, false, false, false);
        descriptor.setTitle("Select a Folder");
        descriptor.setDescription("Choose a Folder to open");
        descriptor.setShowFileSystemRoots(true);

        VirtualFile[] files = FileChooser.chooseFiles(descriptor, null, null);
        if (files.length > 0) {
            return files[0].getPath();
        }
        return "";
    }

    public DocumentListener createListener(JTextField textField, JTextField... textFields) {
        return new DocumentListener() {

            final JTextField[] copyJTextField = getCopyJTextField(textFields);

            public JTextField[] getCopyJTextField(JTextField... textFields) {
                JTextField[] jTextFields = new JTextField[textFields.length];
                for (int i = 0; i < textFields.length; i++) {
                    JTextField jTextField = new JTextField();
                    jTextField.setText(textFields[i].getText());
                    jTextFields[i] = jTextField;
                }
                return jTextFields;
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                exec(copyJTextField, textFields);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                exec(copyJTextField, textFields);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

            private void exec(JTextField[] copyJTextField, JTextField... textFields) {
                for (int i = 0; i < textFields.length; i++) {
                    String text = textField.getText().replace("_", "");
                    if (StringUtil.equals("packageName", textFields[i].getName())) {
                        text = text.replace("-", "");
                    }
                    textFields[i].setText(copyJTextField[i].getText().concat(text));
                }
            }

        };
    }

    public JPanel getGridPanel() {
        return gridPanel;
    }

}
