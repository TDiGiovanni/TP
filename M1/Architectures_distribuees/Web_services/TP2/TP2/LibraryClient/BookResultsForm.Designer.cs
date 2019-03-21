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
            this.resultsListView = new System.Windows.Forms.ListView();
            this.SuspendLayout();
            // 
            // resultsListView
            // 
            this.resultsListView.FullRowSelect = true;
            this.resultsListView.Location = new System.Drawing.Point(12, 12);
            this.resultsListView.Name = "resultsListView";
            this.resultsListView.Size = new System.Drawing.Size(595, 377);
            this.resultsListView.TabIndex = 16;
            this.resultsListView.UseCompatibleStateImageBehavior = false;
            this.resultsListView.View = System.Windows.Forms.View.Details;
            // 
            // BookResultsForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(619, 401);
            this.Controls.Add(this.resultsListView);
            this.Name = "BookResultsForm";
            this.Text = "Results";
            this.ResumeLayout(false);

        }

        #endregion
        private System.Windows.Forms.ListView resultsListView;
    }
}