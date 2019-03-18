namespace LibraryClient
{
    partial class BookResultsForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.authorListBox = new System.Windows.Forms.ListBox();
            this.nameListBox = new System.Windows.Forms.ListBox();
            this.passwordLabel = new System.Windows.Forms.Label();
            this.nameLabel = new System.Windows.Forms.Label();
            this.numberOfCopiesListBox = new System.Windows.Forms.ListBox();
            this.isbnListBox = new System.Windows.Forms.ListBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.editorListBox = new System.Windows.Forms.ListBox();
            this.label3 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // authorListBox
            // 
            this.authorListBox.FormattingEnabled = true;
            this.authorListBox.Location = new System.Drawing.Point(199, 25);
            this.authorListBox.Name = "authorListBox";
            this.authorListBox.Size = new System.Drawing.Size(181, 277);
            this.authorListBox.TabIndex = 8;
            // 
            // nameListBox
            // 
            this.nameListBox.FormattingEnabled = true;
            this.nameListBox.Location = new System.Drawing.Point(12, 25);
            this.nameListBox.Name = "nameListBox";
            this.nameListBox.Size = new System.Drawing.Size(181, 277);
            this.nameListBox.TabIndex = 7;
            // 
            // passwordLabel
            // 
            this.passwordLabel.AutoSize = true;
            this.passwordLabel.Location = new System.Drawing.Point(196, 9);
            this.passwordLabel.Name = "passwordLabel";
            this.passwordLabel.Size = new System.Drawing.Size(38, 13);
            this.passwordLabel.TabIndex = 6;
            this.passwordLabel.Text = "Author";
            // 
            // nameLabel
            // 
            this.nameLabel.AutoSize = true;
            this.nameLabel.Location = new System.Drawing.Point(9, 9);
            this.nameLabel.Name = "nameLabel";
            this.nameLabel.Size = new System.Drawing.Size(35, 13);
            this.nameLabel.TabIndex = 5;
            this.nameLabel.Text = "Name";
            // 
            // numberOfCopiesListBox
            // 
            this.numberOfCopiesListBox.FormattingEnabled = true;
            this.numberOfCopiesListBox.Location = new System.Drawing.Point(573, 25);
            this.numberOfCopiesListBox.Name = "numberOfCopiesListBox";
            this.numberOfCopiesListBox.Size = new System.Drawing.Size(181, 277);
            this.numberOfCopiesListBox.TabIndex = 12;
            // 
            // isbnListBox
            // 
            this.isbnListBox.FormattingEnabled = true;
            this.isbnListBox.Location = new System.Drawing.Point(386, 25);
            this.isbnListBox.Name = "isbnListBox";
            this.isbnListBox.Size = new System.Drawing.Size(181, 277);
            this.isbnListBox.TabIndex = 11;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(570, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(90, 13);
            this.label1.TabIndex = 10;
            this.label1.Text = "Number of copies";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(383, 9);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(32, 13);
            this.label2.TabIndex = 9;
            this.label2.Text = "ISBN";
            // 
            // editorListBox
            // 
            this.editorListBox.FormattingEnabled = true;
            this.editorListBox.Location = new System.Drawing.Point(760, 25);
            this.editorListBox.Name = "editorListBox";
            this.editorListBox.Size = new System.Drawing.Size(181, 277);
            this.editorListBox.TabIndex = 14;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(757, 9);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(34, 13);
            this.label3.TabIndex = 13;
            this.label3.Text = "Editor";
            // 
            // BookResultsForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1007, 380);
            this.Controls.Add(this.editorListBox);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.numberOfCopiesListBox);
            this.Controls.Add(this.isbnListBox);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.authorListBox);
            this.Controls.Add(this.nameListBox);
            this.Controls.Add(this.passwordLabel);
            this.Controls.Add(this.nameLabel);
            this.Name = "BookResultsForm";
            this.Text = "BookResultsForm";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ListBox authorListBox;
        private System.Windows.Forms.ListBox nameListBox;
        private System.Windows.Forms.Label passwordLabel;
        private System.Windows.Forms.Label nameLabel;
        private System.Windows.Forms.ListBox numberOfCopiesListBox;
        private System.Windows.Forms.ListBox isbnListBox;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ListBox editorListBox;
        private System.Windows.Forms.Label label3;
    }
}