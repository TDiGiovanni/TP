﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Ce code a été généré par un outil.
//     Version du runtime :4.0.30319.42000
//
//     Les modifications apportées à ce fichier peuvent provoquer un comportement incorrect et seront perdues si
//     le code est régénéré.
// </auto-generated>
//------------------------------------------------------------------------------

// 
// Ce code source a été automatiquement généré par Microsoft.VSDesigner, Version 4.0.30319.42000.
// 
#pragma warning disable 1591

namespace LibraryClient.LibraryWebService {
    using System;
    using System.Web.Services;
    using System.Diagnostics;
    using System.Web.Services.Protocols;
    using System.Xml.Serialization;
    using System.ComponentModel;
    
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.3056.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Web.Services.WebServiceBindingAttribute(Name="LibraryWebServiceSoap", Namespace="http://tempuri.org/")]
    public partial class LibraryWebService : System.Web.Services.Protocols.SoapHttpClientProtocol {
        
        private System.Threading.SendOrPostCallback AddBookOperationCompleted;
        
        private System.Threading.SendOrPostCallback AddSubscriberOperationCompleted;
        
        private System.Threading.SendOrPostCallback GetSubscriberOperationCompleted;
        
        private System.Threading.SendOrPostCallback GetAllBooksOperationCompleted;
        
        private System.Threading.SendOrPostCallback GetBookByIsbnOperationCompleted;
        
        private System.Threading.SendOrPostCallback GetBooksByAuthorOperationCompleted;
        
        private System.Threading.SendOrPostCallback GetAllSubscribersOperationCompleted;
        
        private System.Threading.SendOrPostCallback GetSubscribersByNameOperationCompleted;
        
        private System.Threading.SendOrPostCallback LeaveCommentOperationCompleted;
        
        private bool useDefaultCredentialsSetExplicitly;
        
        /// <remarks/>
        public LibraryWebService() {
            this.Url = global::LibraryClient.Properties.Settings.Default.LibraryClient_LibraryWebService_LibraryWebService;
            if ((this.IsLocalFileSystemWebService(this.Url) == true)) {
                this.UseDefaultCredentials = true;
                this.useDefaultCredentialsSetExplicitly = false;
            }
            else {
                this.useDefaultCredentialsSetExplicitly = true;
            }
        }
        
        public new string Url {
            get {
                return base.Url;
            }
            set {
                if ((((this.IsLocalFileSystemWebService(base.Url) == true) 
                            && (this.useDefaultCredentialsSetExplicitly == false)) 
                            && (this.IsLocalFileSystemWebService(value) == false))) {
                    base.UseDefaultCredentials = false;
                }
                base.Url = value;
            }
        }
        
        public new bool UseDefaultCredentials {
            get {
                return base.UseDefaultCredentials;
            }
            set {
                base.UseDefaultCredentials = value;
                this.useDefaultCredentialsSetExplicitly = true;
            }
        }
        
        /// <remarks/>
        public event AddBookCompletedEventHandler AddBookCompleted;
        
        /// <remarks/>
        public event AddSubscriberCompletedEventHandler AddSubscriberCompleted;
        
        /// <remarks/>
        public event GetSubscriberCompletedEventHandler GetSubscriberCompleted;
        
        /// <remarks/>
        public event GetAllBooksCompletedEventHandler GetAllBooksCompleted;
        
        /// <remarks/>
        public event GetBookByIsbnCompletedEventHandler GetBookByIsbnCompleted;
        
        /// <remarks/>
        public event GetBooksByAuthorCompletedEventHandler GetBooksByAuthorCompleted;
        
        /// <remarks/>
        public event GetAllSubscribersCompletedEventHandler GetAllSubscribersCompleted;
        
        /// <remarks/>
        public event GetSubscribersByNameCompletedEventHandler GetSubscribersByNameCompleted;
        
        /// <remarks/>
        public event LeaveCommentCompletedEventHandler LeaveCommentCompleted;
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/AddBook", RequestNamespace="http://tempuri.org/", ResponseNamespace="http://tempuri.org/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public void AddBook(string title, string author, int isbn, int numberOfCopies, string editor) {
            this.Invoke("AddBook", new object[] {
                        title,
                        author,
                        isbn,
                        numberOfCopies,
                        editor});
        }
        
        /// <remarks/>
        public void AddBookAsync(string title, string author, int isbn, int numberOfCopies, string editor) {
            this.AddBookAsync(title, author, isbn, numberOfCopies, editor, null);
        }
        
        /// <remarks/>
        public void AddBookAsync(string title, string author, int isbn, int numberOfCopies, string editor, object userState) {
            if ((this.AddBookOperationCompleted == null)) {
                this.AddBookOperationCompleted = new System.Threading.SendOrPostCallback(this.OnAddBookOperationCompleted);
            }
            this.InvokeAsync("AddBook", new object[] {
                        title,
                        author,
                        isbn,
                        numberOfCopies,
                        editor}, this.AddBookOperationCompleted, userState);
        }
        
        private void OnAddBookOperationCompleted(object arg) {
            if ((this.AddBookCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.AddBookCompleted(this, new System.ComponentModel.AsyncCompletedEventArgs(invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/AddSubscriber", RequestNamespace="http://tempuri.org/", ResponseNamespace="http://tempuri.org/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public int AddSubscriber(string name, string password) {
            object[] results = this.Invoke("AddSubscriber", new object[] {
                        name,
                        password});
            return ((int)(results[0]));
        }
        
        /// <remarks/>
        public void AddSubscriberAsync(string name, string password) {
            this.AddSubscriberAsync(name, password, null);
        }
        
        /// <remarks/>
        public void AddSubscriberAsync(string name, string password, object userState) {
            if ((this.AddSubscriberOperationCompleted == null)) {
                this.AddSubscriberOperationCompleted = new System.Threading.SendOrPostCallback(this.OnAddSubscriberOperationCompleted);
            }
            this.InvokeAsync("AddSubscriber", new object[] {
                        name,
                        password}, this.AddSubscriberOperationCompleted, userState);
        }
        
        private void OnAddSubscriberOperationCompleted(object arg) {
            if ((this.AddSubscriberCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.AddSubscriberCompleted(this, new AddSubscriberCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/GetSubscriber", RequestNamespace="http://tempuri.org/", ResponseNamespace="http://tempuri.org/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public Subscriber GetSubscriber(int number, string password) {
            object[] results = this.Invoke("GetSubscriber", new object[] {
                        number,
                        password});
            return ((Subscriber)(results[0]));
        }
        
        /// <remarks/>
        public void GetSubscriberAsync(int number, string password) {
            this.GetSubscriberAsync(number, password, null);
        }
        
        /// <remarks/>
        public void GetSubscriberAsync(int number, string password, object userState) {
            if ((this.GetSubscriberOperationCompleted == null)) {
                this.GetSubscriberOperationCompleted = new System.Threading.SendOrPostCallback(this.OnGetSubscriberOperationCompleted);
            }
            this.InvokeAsync("GetSubscriber", new object[] {
                        number,
                        password}, this.GetSubscriberOperationCompleted, userState);
        }
        
        private void OnGetSubscriberOperationCompleted(object arg) {
            if ((this.GetSubscriberCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.GetSubscriberCompleted(this, new GetSubscriberCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/GetAllBooks", RequestNamespace="http://tempuri.org/", ResponseNamespace="http://tempuri.org/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public Book[] GetAllBooks() {
            object[] results = this.Invoke("GetAllBooks", new object[0]);
            return ((Book[])(results[0]));
        }
        
        /// <remarks/>
        public void GetAllBooksAsync() {
            this.GetAllBooksAsync(null);
        }
        
        /// <remarks/>
        public void GetAllBooksAsync(object userState) {
            if ((this.GetAllBooksOperationCompleted == null)) {
                this.GetAllBooksOperationCompleted = new System.Threading.SendOrPostCallback(this.OnGetAllBooksOperationCompleted);
            }
            this.InvokeAsync("GetAllBooks", new object[0], this.GetAllBooksOperationCompleted, userState);
        }
        
        private void OnGetAllBooksOperationCompleted(object arg) {
            if ((this.GetAllBooksCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.GetAllBooksCompleted(this, new GetAllBooksCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/GetBookByIsbn", RequestNamespace="http://tempuri.org/", ResponseNamespace="http://tempuri.org/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public Book GetBookByIsbn(int isbn) {
            object[] results = this.Invoke("GetBookByIsbn", new object[] {
                        isbn});
            return ((Book)(results[0]));
        }
        
        /// <remarks/>
        public void GetBookByIsbnAsync(int isbn) {
            this.GetBookByIsbnAsync(isbn, null);
        }
        
        /// <remarks/>
        public void GetBookByIsbnAsync(int isbn, object userState) {
            if ((this.GetBookByIsbnOperationCompleted == null)) {
                this.GetBookByIsbnOperationCompleted = new System.Threading.SendOrPostCallback(this.OnGetBookByIsbnOperationCompleted);
            }
            this.InvokeAsync("GetBookByIsbn", new object[] {
                        isbn}, this.GetBookByIsbnOperationCompleted, userState);
        }
        
        private void OnGetBookByIsbnOperationCompleted(object arg) {
            if ((this.GetBookByIsbnCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.GetBookByIsbnCompleted(this, new GetBookByIsbnCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/GetBooksByAuthor", RequestNamespace="http://tempuri.org/", ResponseNamespace="http://tempuri.org/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public Book[] GetBooksByAuthor(string author) {
            object[] results = this.Invoke("GetBooksByAuthor", new object[] {
                        author});
            return ((Book[])(results[0]));
        }
        
        /// <remarks/>
        public void GetBooksByAuthorAsync(string author) {
            this.GetBooksByAuthorAsync(author, null);
        }
        
        /// <remarks/>
        public void GetBooksByAuthorAsync(string author, object userState) {
            if ((this.GetBooksByAuthorOperationCompleted == null)) {
                this.GetBooksByAuthorOperationCompleted = new System.Threading.SendOrPostCallback(this.OnGetBooksByAuthorOperationCompleted);
            }
            this.InvokeAsync("GetBooksByAuthor", new object[] {
                        author}, this.GetBooksByAuthorOperationCompleted, userState);
        }
        
        private void OnGetBooksByAuthorOperationCompleted(object arg) {
            if ((this.GetBooksByAuthorCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.GetBooksByAuthorCompleted(this, new GetBooksByAuthorCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/GetAllSubscribers", RequestNamespace="http://tempuri.org/", ResponseNamespace="http://tempuri.org/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public Subscriber[] GetAllSubscribers() {
            object[] results = this.Invoke("GetAllSubscribers", new object[0]);
            return ((Subscriber[])(results[0]));
        }
        
        /// <remarks/>
        public void GetAllSubscribersAsync() {
            this.GetAllSubscribersAsync(null);
        }
        
        /// <remarks/>
        public void GetAllSubscribersAsync(object userState) {
            if ((this.GetAllSubscribersOperationCompleted == null)) {
                this.GetAllSubscribersOperationCompleted = new System.Threading.SendOrPostCallback(this.OnGetAllSubscribersOperationCompleted);
            }
            this.InvokeAsync("GetAllSubscribers", new object[0], this.GetAllSubscribersOperationCompleted, userState);
        }
        
        private void OnGetAllSubscribersOperationCompleted(object arg) {
            if ((this.GetAllSubscribersCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.GetAllSubscribersCompleted(this, new GetAllSubscribersCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/GetSubscribersByName", RequestNamespace="http://tempuri.org/", ResponseNamespace="http://tempuri.org/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public Subscriber[] GetSubscribersByName(string name) {
            object[] results = this.Invoke("GetSubscribersByName", new object[] {
                        name});
            return ((Subscriber[])(results[0]));
        }
        
        /// <remarks/>
        public void GetSubscribersByNameAsync(string name) {
            this.GetSubscribersByNameAsync(name, null);
        }
        
        /// <remarks/>
        public void GetSubscribersByNameAsync(string name, object userState) {
            if ((this.GetSubscribersByNameOperationCompleted == null)) {
                this.GetSubscribersByNameOperationCompleted = new System.Threading.SendOrPostCallback(this.OnGetSubscribersByNameOperationCompleted);
            }
            this.InvokeAsync("GetSubscribersByName", new object[] {
                        name}, this.GetSubscribersByNameOperationCompleted, userState);
        }
        
        private void OnGetSubscribersByNameOperationCompleted(object arg) {
            if ((this.GetSubscribersByNameCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.GetSubscribersByNameCompleted(this, new GetSubscribersByNameCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/LeaveComment", RequestNamespace="http://tempuri.org/", ResponseNamespace="http://tempuri.org/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public bool LeaveComment(int subscriberNumber, string subscriberPassword, int isbn, string comment) {
            object[] results = this.Invoke("LeaveComment", new object[] {
                        subscriberNumber,
                        subscriberPassword,
                        isbn,
                        comment});
            return ((bool)(results[0]));
        }
        
        /// <remarks/>
        public void LeaveCommentAsync(int subscriberNumber, string subscriberPassword, int isbn, string comment) {
            this.LeaveCommentAsync(subscriberNumber, subscriberPassword, isbn, comment, null);
        }
        
        /// <remarks/>
        public void LeaveCommentAsync(int subscriberNumber, string subscriberPassword, int isbn, string comment, object userState) {
            if ((this.LeaveCommentOperationCompleted == null)) {
                this.LeaveCommentOperationCompleted = new System.Threading.SendOrPostCallback(this.OnLeaveCommentOperationCompleted);
            }
            this.InvokeAsync("LeaveComment", new object[] {
                        subscriberNumber,
                        subscriberPassword,
                        isbn,
                        comment}, this.LeaveCommentOperationCompleted, userState);
        }
        
        private void OnLeaveCommentOperationCompleted(object arg) {
            if ((this.LeaveCommentCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.LeaveCommentCompleted(this, new LeaveCommentCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        public new void CancelAsync(object userState) {
            base.CancelAsync(userState);
        }
        
        private bool IsLocalFileSystemWebService(string url) {
            if (((url == null) 
                        || (url == string.Empty))) {
                return false;
            }
            System.Uri wsUri = new System.Uri(url);
            if (((wsUri.Port >= 1024) 
                        && (string.Compare(wsUri.Host, "localHost", System.StringComparison.OrdinalIgnoreCase) == 0))) {
                return true;
            }
            return false;
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.7.3056.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://tempuri.org/")]
    public partial class Subscriber {
        
        private int numberField;
        
        private string nameField;
        
        private string passwordField;
        
        /// <remarks/>
        public int number {
            get {
                return this.numberField;
            }
            set {
                this.numberField = value;
            }
        }
        
        /// <remarks/>
        public string name {
            get {
                return this.nameField;
            }
            set {
                this.nameField = value;
            }
        }
        
        /// <remarks/>
        public string password {
            get {
                return this.passwordField;
            }
            set {
                this.passwordField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.7.3056.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://tempuri.org/")]
    public partial class Comment {
        
        private Subscriber authorField;
        
        private string textField;
        
        /// <remarks/>
        public Subscriber author {
            get {
                return this.authorField;
            }
            set {
                this.authorField = value;
            }
        }
        
        /// <remarks/>
        public string text {
            get {
                return this.textField;
            }
            set {
                this.textField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.7.3056.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://tempuri.org/")]
    public partial class Book {
        
        private string titleField;
        
        private string authorField;
        
        private int isbnField;
        
        private int numberOfCopiesField;
        
        private string editorField;
        
        private Comment[] commentsField;
        
        /// <remarks/>
        public string title {
            get {
                return this.titleField;
            }
            set {
                this.titleField = value;
            }
        }
        
        /// <remarks/>
        public string author {
            get {
                return this.authorField;
            }
            set {
                this.authorField = value;
            }
        }
        
        /// <remarks/>
        public int isbn {
            get {
                return this.isbnField;
            }
            set {
                this.isbnField = value;
            }
        }
        
        /// <remarks/>
        public int numberOfCopies {
            get {
                return this.numberOfCopiesField;
            }
            set {
                this.numberOfCopiesField = value;
            }
        }
        
        /// <remarks/>
        public string editor {
            get {
                return this.editorField;
            }
            set {
                this.editorField = value;
            }
        }
        
        /// <remarks/>
        public Comment[] comments {
            get {
                return this.commentsField;
            }
            set {
                this.commentsField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.3056.0")]
    public delegate void AddBookCompletedEventHandler(object sender, System.ComponentModel.AsyncCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.3056.0")]
    public delegate void AddSubscriberCompletedEventHandler(object sender, AddSubscriberCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.3056.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class AddSubscriberCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal AddSubscriberCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public int Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((int)(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.3056.0")]
    public delegate void GetSubscriberCompletedEventHandler(object sender, GetSubscriberCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.3056.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class GetSubscriberCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal GetSubscriberCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public Subscriber Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((Subscriber)(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.3056.0")]
    public delegate void GetAllBooksCompletedEventHandler(object sender, GetAllBooksCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.3056.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class GetAllBooksCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal GetAllBooksCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public Book[] Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((Book[])(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.3056.0")]
    public delegate void GetBookByIsbnCompletedEventHandler(object sender, GetBookByIsbnCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.3056.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class GetBookByIsbnCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal GetBookByIsbnCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public Book Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((Book)(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.3056.0")]
    public delegate void GetBooksByAuthorCompletedEventHandler(object sender, GetBooksByAuthorCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.3056.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class GetBooksByAuthorCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal GetBooksByAuthorCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public Book[] Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((Book[])(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.3056.0")]
    public delegate void GetAllSubscribersCompletedEventHandler(object sender, GetAllSubscribersCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.3056.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class GetAllSubscribersCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal GetAllSubscribersCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public Subscriber[] Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((Subscriber[])(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.3056.0")]
    public delegate void GetSubscribersByNameCompletedEventHandler(object sender, GetSubscribersByNameCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.3056.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class GetSubscribersByNameCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal GetSubscribersByNameCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public Subscriber[] Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((Subscriber[])(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.3056.0")]
    public delegate void LeaveCommentCompletedEventHandler(object sender, LeaveCommentCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Web.Services", "4.7.3056.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class LeaveCommentCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal LeaveCommentCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public bool Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((bool)(this.results[0]));
            }
        }
    }
}

#pragma warning restore 1591