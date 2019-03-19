namespace LibraryClient
{
    partial class LibraryManagerForm
    {
        /// <summary>
        /// Variable nécessaire au concepteur.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Nettoyage des ressources utilisées.
        /// </summary>
        /// <param name="disposing">true si les ressources managées doivent être supprimées ; sinon, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Code généré par le Concepteur Windows Form

        /// <summary>
        /// Méthode requise pour la prise en charge du concepteur - ne modifiez pas
        /// le contenu de cette méthode avec l'éditeur de code.
        /// </summary>
        private void InitializeComponent()
        {
            this.label3 = new System.Windows.Forms.Label();
            this.bookEditorTextBox = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.bookNumberOfCopiesTextBox = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.bookIsbnTextBox = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.subscriberPasswordTextBox = new System.Windows.Forms.TextBox();
            this.label6 = new System.Windows.Forms.Label();
            this.subscriberNameTextBox = new System.Windows.Forms.TextBox();
            this.bookLabel = new System.Windows.Forms.Label();
            this.bookAuthorLabel = new System.Windows.Forms.Label();
            this.bookAuthorTextBox = new System.Windows.Forms.TextBox();
            this.bookTitleLabel = new System.Windows.Forms.Label();
            this.bookTitleTextBox = new System.Windows.Forms.TextBox();
            this.addBookButton = new System.Windows.Forms.Button();
            this.addSubscriberButton = new System.Windows.Forms.Button();
            this.getAllBooksButton = new System.Windows.Forms.Button();
            this.getAllSubscribersButton = new System.Windows.Forms.Button();
            this.getBookByAuthorButton = new System.Windows.Forms.Button();
            this.getBookByIsbnButton = new System.Windows.Forms.Button();
            this.getSubscriberByNameButton = new System.Windows.Forms.Button();
            this.getAllCommentsButton = new System.Windows.Forms.Button();
            this.leaveCommentButton = new System.Windows.Forms.Button();
            this.commentLabel = new System.Windows.Forms.Label();
            this.subscriberCommentTextBox = new System.Windows.Forms.TextBox();
            this.numberLabel = new System.Windows.Forms.Label();
            this.subscriberNumberTextBox = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(72, 161);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(37, 13);
            this.label3.TabIndex = 56;
            this.label3.Text = "Editor:";
            // 
            // bookEditorTextBox
            // 
            this.bookEditorTextBox.Location = new System.Drawing.Point(196, 158);
            this.bookEditorTextBox.Name = "bookEditorTextBox";
            this.bookEditorTextBox.Size = new System.Drawing.Size(165, 20);
            this.bookEditorTextBox.TabIndex = 55;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(72, 135);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(93, 13);
            this.label2.TabIndex = 54;
            this.label2.Text = "Number of copies:";
            // 
            // bookNumberOfCopiesTextBox
            // 
            this.bookNumberOfCopiesTextBox.Location = new System.Drawing.Point(196, 132);
            this.bookNumberOfCopiesTextBox.Name = "bookNumberOfCopiesTextBox";
            this.bookNumberOfCopiesTextBox.Size = new System.Drawing.Size(165, 20);
            this.bookNumberOfCopiesTextBox.TabIndex = 53;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(72, 109);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(35, 13);
            this.label1.TabIndex = 52;
            this.label1.Text = "ISBN:";
            // 
            // bookIsbnTextBox
            // 
            this.bookIsbnTextBox.Location = new System.Drawing.Point(196, 106);
            this.bookIsbnTextBox.Name = "bookIsbnTextBox";
            this.bookIsbnTextBox.Size = new System.Drawing.Size(165, 20);
            this.bookIsbnTextBox.TabIndex = 51;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(481, 25);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(60, 13);
            this.label4.TabIndex = 50;
            this.label4.Text = "Subscriber:";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(526, 109);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(56, 13);
            this.label5.TabIndex = 49;
            this.label5.Text = "Password:";
            // 
            // subscriberPasswordTextBox
            // 
            this.subscriberPasswordTextBox.Location = new System.Drawing.Point(607, 106);
            this.subscriberPasswordTextBox.Name = "subscriberPasswordTextBox";
            this.subscriberPasswordTextBox.Size = new System.Drawing.Size(163, 20);
            this.subscriberPasswordTextBox.TabIndex = 48;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(526, 57);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(38, 13);
            this.label6.TabIndex = 47;
            this.label6.Text = "Name:";
            // 
            // subscriberNameTextBox
            // 
            this.subscriberNameTextBox.Location = new System.Drawing.Point(607, 54);
            this.subscriberNameTextBox.Name = "subscriberNameTextBox";
            this.subscriberNameTextBox.Size = new System.Drawing.Size(163, 20);
            this.subscriberNameTextBox.TabIndex = 46;
            // 
            // bookLabel
            // 
            this.bookLabel.AutoSize = true;
            this.bookLabel.Location = new System.Drawing.Point(27, 25);
            this.bookLabel.Name = "bookLabel";
            this.bookLabel.Size = new System.Drawing.Size(35, 13);
            this.bookLabel.TabIndex = 45;
            this.bookLabel.Text = "Book:";
            // 
            // bookAuthorLabel
            // 
            this.bookAuthorLabel.AutoSize = true;
            this.bookAuthorLabel.Location = new System.Drawing.Point(72, 83);
            this.bookAuthorLabel.Name = "bookAuthorLabel";
            this.bookAuthorLabel.Size = new System.Drawing.Size(41, 13);
            this.bookAuthorLabel.TabIndex = 44;
            this.bookAuthorLabel.Text = "Author:";
            // 
            // bookAuthorTextBox
            // 
            this.bookAuthorTextBox.Location = new System.Drawing.Point(196, 80);
            this.bookAuthorTextBox.Name = "bookAuthorTextBox";
            this.bookAuthorTextBox.Size = new System.Drawing.Size(165, 20);
            this.bookAuthorTextBox.TabIndex = 43;
            // 
            // bookTitleLabel
            // 
            this.bookTitleLabel.AutoSize = true;
            this.bookTitleLabel.Location = new System.Drawing.Point(72, 57);
            this.bookTitleLabel.Name = "bookTitleLabel";
            this.bookTitleLabel.Size = new System.Drawing.Size(30, 13);
            this.bookTitleLabel.TabIndex = 42;
            this.bookTitleLabel.Text = "Title:";
            // 
            // bookTitleTextBox
            // 
            this.bookTitleTextBox.Location = new System.Drawing.Point(196, 54);
            this.bookTitleTextBox.Name = "bookTitleTextBox";
            this.bookTitleTextBox.Size = new System.Drawing.Size(165, 20);
            this.bookTitleTextBox.TabIndex = 41;
            // 
            // addBookButton
            // 
            this.addBookButton.Location = new System.Drawing.Point(30, 237);
            this.addBookButton.Name = "addBookButton";
            this.addBookButton.Size = new System.Drawing.Size(163, 32);
            this.addBookButton.TabIndex = 39;
            this.addBookButton.Text = "Add a book";
            this.addBookButton.UseVisualStyleBackColor = true;
            this.addBookButton.Click += new System.EventHandler(this.AddBookButton_Click);
            // 
            // addSubscriberButton
            // 
            this.addSubscriberButton.Location = new System.Drawing.Point(484, 237);
            this.addSubscriberButton.Name = "addSubscriberButton";
            this.addSubscriberButton.Size = new System.Drawing.Size(163, 32);
            this.addSubscriberButton.TabIndex = 38;
            this.addSubscriberButton.Text = "Add a subscriber";
            this.addSubscriberButton.UseVisualStyleBackColor = true;
            this.addSubscriberButton.Click += new System.EventHandler(this.AddSubscriberButton_Click);
            // 
            // getAllBooksButton
            // 
            this.getAllBooksButton.Location = new System.Drawing.Point(212, 237);
            this.getAllBooksButton.Name = "getAllBooksButton";
            this.getAllBooksButton.Size = new System.Drawing.Size(163, 32);
            this.getAllBooksButton.TabIndex = 57;
            this.getAllBooksButton.Text = "Get all books";
            this.getAllBooksButton.UseVisualStyleBackColor = true;
            this.getAllBooksButton.Click += new System.EventHandler(this.GetAllBooksButton_Click);
            // 
            // getAllSubscribersButton
            // 
            this.getAllSubscribersButton.Location = new System.Drawing.Point(666, 237);
            this.getAllSubscribersButton.Name = "getAllSubscribersButton";
            this.getAllSubscribersButton.Size = new System.Drawing.Size(163, 32);
            this.getAllSubscribersButton.TabIndex = 58;
            this.getAllSubscribersButton.Text = "Get all subscribers";
            this.getAllSubscribersButton.UseVisualStyleBackColor = true;
            this.getAllSubscribersButton.Click += new System.EventHandler(this.GetAllSubscribersButton_Click);
            // 
            // getBookByAuthorButton
            // 
            this.getBookByAuthorButton.Location = new System.Drawing.Point(212, 275);
            this.getBookByAuthorButton.Name = "getBookByAuthorButton";
            this.getBookByAuthorButton.Size = new System.Drawing.Size(163, 32);
            this.getBookByAuthorButton.TabIndex = 59;
            this.getBookByAuthorButton.Text = "Get books by author";
            this.getBookByAuthorButton.UseVisualStyleBackColor = true;
            this.getBookByAuthorButton.Click += new System.EventHandler(this.GetBookByTitleButton_Click);
            // 
            // getBookByIsbnButton
            // 
            this.getBookByIsbnButton.Location = new System.Drawing.Point(212, 313);
            this.getBookByIsbnButton.Name = "getBookByIsbnButton";
            this.getBookByIsbnButton.Size = new System.Drawing.Size(163, 32);
            this.getBookByIsbnButton.TabIndex = 60;
            this.getBookByIsbnButton.Text = "Get a book by ISBN";
            this.getBookByIsbnButton.UseVisualStyleBackColor = true;
            this.getBookByIsbnButton.Click += new System.EventHandler(this.GetBookByIsbnButton_Click);
            // 
            // getSubscriberByNameButton
            // 
            this.getSubscriberByNameButton.Location = new System.Drawing.Point(666, 275);
            this.getSubscriberByNameButton.Name = "getSubscriberByNameButton";
            this.getSubscriberByNameButton.Size = new System.Drawing.Size(163, 32);
            this.getSubscriberByNameButton.TabIndex = 61;
            this.getSubscriberByNameButton.Text = "Get subscribers by name";
            this.getSubscriberByNameButton.UseVisualStyleBackColor = true;
            this.getSubscriberByNameButton.Click += new System.EventHandler(this.GetSubscriberByNameButton_Click);
            // 
            // getAllCommentsButton
            // 
            this.getAllCommentsButton.Location = new System.Drawing.Point(212, 351);
            this.getAllCommentsButton.Name = "getAllCommentsButton";
            this.getAllCommentsButton.Size = new System.Drawing.Size(163, 32);
            this.getAllCommentsButton.TabIndex = 62;
            this.getAllCommentsButton.Text = "Get all comments";
            this.getAllCommentsButton.UseVisualStyleBackColor = true;
            this.getAllCommentsButton.Click += new System.EventHandler(this.GetAllCommentsButton_Click);
            // 
            // leaveCommentButton
            // 
            this.leaveCommentButton.Location = new System.Drawing.Point(666, 313);
            this.leaveCommentButton.Name = "leaveCommentButton";
            this.leaveCommentButton.Size = new System.Drawing.Size(163, 32);
            this.leaveCommentButton.TabIndex = 63;
            this.leaveCommentButton.Text = "Leave a comment";
            this.leaveCommentButton.UseVisualStyleBackColor = true;
            this.leaveCommentButton.Click += new System.EventHandler(this.LeaveCommentButton_Click);
            // 
            // commentLabel
            // 
            this.commentLabel.AutoSize = true;
            this.commentLabel.Location = new System.Drawing.Point(526, 135);
            this.commentLabel.Name = "commentLabel";
            this.commentLabel.Size = new System.Drawing.Size(54, 13);
            this.commentLabel.TabIndex = 65;
            this.commentLabel.Text = "Comment:";
            // 
            // subscriberCommentTextBox
            // 
            this.subscriberCommentTextBox.Location = new System.Drawing.Point(607, 132);
            this.subscriberCommentTextBox.Name = "subscriberCommentTextBox";
            this.subscriberCommentTextBox.Size = new System.Drawing.Size(163, 20);
            this.subscriberCommentTextBox.TabIndex = 64;
            // 
            // numberLabel
            // 
            this.numberLabel.AutoSize = true;
            this.numberLabel.Location = new System.Drawing.Point(526, 83);
            this.numberLabel.Name = "numberLabel";
            this.numberLabel.Size = new System.Drawing.Size(47, 13);
            this.numberLabel.TabIndex = 67;
            this.numberLabel.Text = "Number:";
            // 
            // subscriberNumberTextBox
            // 
            this.subscriberNumberTextBox.Location = new System.Drawing.Point(607, 80);
            this.subscriberNumberTextBox.Name = "subscriberNumberTextBox";
            this.subscriberNumberTextBox.Size = new System.Drawing.Size(163, 20);
            this.subscriberNumberTextBox.TabIndex = 66;
            // 
            // LibraryManagerForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(892, 416);
            this.Controls.Add(this.numberLabel);
            this.Controls.Add(this.subscriberNumberTextBox);
            this.Controls.Add(this.commentLabel);
            this.Controls.Add(this.subscriberCommentTextBox);
            this.Controls.Add(this.leaveCommentButton);
            this.Controls.Add(this.getAllCommentsButton);
            this.Controls.Add(this.getSubscriberByNameButton);
            this.Controls.Add(this.getBookByIsbnButton);
            this.Controls.Add(this.getBookByAuthorButton);
            this.Controls.Add(this.getAllSubscribersButton);
            this.Controls.Add(this.getAllBooksButton);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.bookEditorTextBox);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.bookNumberOfCopiesTextBox);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.bookIsbnTextBox);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.subscriberPasswordTextBox);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.subscriberNameTextBox);
            this.Controls.Add(this.bookLabel);
            this.Controls.Add(this.bookAuthorLabel);
            this.Controls.Add(this.bookAuthorTextBox);
            this.Controls.Add(this.bookTitleLabel);
            this.Controls.Add(this.bookTitleTextBox);
            this.Controls.Add(this.addBookButton);
            this.Controls.Add(this.addSubscriberButton);
            this.Name = "LibraryManagerForm";
            this.Text = "Library manager";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox bookEditorTextBox;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox bookNumberOfCopiesTextBox;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox bookIsbnTextBox;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox subscriberPasswordTextBox;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.TextBox subscriberNameTextBox;
        private System.Windows.Forms.Label bookLabel;
        private System.Windows.Forms.Label bookAuthorLabel;
        private System.Windows.Forms.TextBox bookAuthorTextBox;
        private System.Windows.Forms.Label bookTitleLabel;
        private System.Windows.Forms.TextBox bookTitleTextBox;
        private System.Windows.Forms.Button addBookButton;
        private System.Windows.Forms.Button addSubscriberButton;
        private System.Windows.Forms.Button getAllBooksButton;
        private System.Windows.Forms.Button getAllSubscribersButton;
        private System.Windows.Forms.Button getBookByAuthorButton;
        private System.Windows.Forms.Button getBookByIsbnButton;
        private System.Windows.Forms.Button getSubscriberByNameButton;
        private System.Windows.Forms.Button getAllCommentsButton;
        private System.Windows.Forms.Button leaveCommentButton;
        private System.Windows.Forms.Label commentLabel;
        private System.Windows.Forms.TextBox subscriberCommentTextBox;
        private System.Windows.Forms.Label numberLabel;
        private System.Windows.Forms.TextBox subscriberNumberTextBox;
    }
}

