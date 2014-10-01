<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
body {
	margin: 0;
	padding: 0;
}
.cuubez-section pre code {
	display: block;
	padding: 0.5em;
	background: #F0F0F0;
}
.cuubez-section pre code, .cuubez-section pre .subst, .cuubez-section pre .tag .title, .cuubez-section pre .lisp .title, .cuubez-section pre .clojure .built_in, .cuubez-section pre .nginx .title {
	color: black;
}
.cuubez-section pre .string, .cuubez-section pre .title, .cuubez-section pre .constant, .cuubez-section pre .parent, .cuubez-section pre .tag .value, .cuubez-section pre .rules .value, .cuubez-section pre .rules .value .number, .cuubez-section pre .preprocessor, .cuubez-section pre .ruby .symbol, .cuubez-section pre .ruby .symbol .string, .cuubez-section pre .aggregate, .cuubez-section pre .template_tag, .cuubez-section pre .django .variable, .cuubez-section pre .smalltalk .class, .cuubez-section pre .addition, .cuubez-section pre .flow, .cuubez-section pre .stream, .cuubez-section pre .bash .variable, .cuubez-section pre .apache .tag, .cuubez-section pre .apache .cbracket, .cuubez-section pre .tex .command, .cuubez-section pre .tex .special, .cuubez-section pre .erlang_repl .function_or_atom, .cuubez-section pre .markdown .header {
	color: #800;
}
.cuubez-section pre .comment, .cuubez-section pre .annotation, .cuubez-section pre .template_comment, .cuubez-section pre .diff .header, .cuubez-section pre .chunk, .cuubez-section pre .markdown .blockquote {
	color: #888;
}
.cuubez-section pre .number, .cuubez-section pre .date, .cuubez-section pre .regexp, .cuubez-section pre .literal, .cuubez-section pre .smalltalk .symbol, .cuubez-section pre .smalltalk .char, .cuubez-section pre .go .constant, .cuubez-section pre .change, .cuubez-section pre .markdown .bullet, .cuubez-section pre .markdown .link_url {
	color: #080;
}
.cuubez-section pre .label, .cuubez-section pre .javadoc, .cuubez-section pre .ruby .string, .cuubez-section pre .decorator, .cuubez-section pre .filter .argument, .cuubez-section pre .localvars, .cuubez-section pre .array, .cuubez-section pre .attr_selector, .cuubez-section pre .important, .cuubez-section pre .pseudo, .cuubez-section pre .pi, .cuubez-section pre .doctype, .cuubez-section pre .deletion, .cuubez-section pre .envvar, .cuubez-section pre .shebang, .cuubez-section pre .apache .sqbracket, .cuubez-section pre .nginx .built_in, .cuubez-section pre .tex .formula, .cuubez-section pre .erlang_repl .reserved, .cuubez-section pre .prompt, .cuubez-section pre .markdown .link_label, .cuubez-section pre .vhdl .attribute, .cuubez-section pre .clojure .attribute, .cuubez-section pre .coffeescript .property {
	color: #8888ff;
}
.cuubez-section pre .keyword, .cuubez-section pre .id, .cuubez-section pre .phpdoc, .cuubez-section pre .title, .cuubez-section pre .built_in, .cuubez-section pre .aggregate, .cuubez-section pre .css .tag, .cuubez-section pre .javadoctag, .cuubez-section pre .phpdoc, .cuubez-section pre .yardoctag, .cuubez-section pre .smalltalk .class, .cuubez-section pre .winutils, .cuubez-section pre .bash .variable, .cuubez-section pre .apache .tag, .cuubez-section pre .go .typename, .cuubez-section pre .tex .command, .cuubez-section pre .markdown .strong, .cuubez-section pre .request, .cuubez-section pre .status {
	font-weight: bold;
}
.cuubez-section pre .markdown .emphasis {
	font-style: italic;
}
.cuubez-section pre .nginx .built_in {
	font-weight: normal;
}
.cuubez-section pre .coffeescript .javascript, .cuubez-section pre .javascript .xml, .cuubez-section pre .tex .formula, .cuubez-section pre .xml .javascript, .cuubez-section pre .xml .vbscript, .cuubez-section pre .xml .css, .cuubez-section pre .xml .cdata {
	opacity: 0.5;
}
.cuubez-section .cuubez-ui-wrap {
	line-height: 1;
	font-family: "Droid Sans", sans-serif;
	max-width: 960px;
	margin-left: auto;
	margin-right: auto;
        margin-bottom: 50px;
}
.cuubez-section .cuubez-ui-wrap b, .cuubez-section .cuubez-ui-wrap strong {
	font-family: "Droid Sans", sans-serif;
	font-weight: bold;
}
.cuubez-section .cuubez-ui-wrap q, .cuubez-section .cuubez-ui-wrap blockquote {
	quotes: none;
}
.cuubez-section .cuubez-ui-wrap p {
	line-height: 1.4em;
	padding: 0 0 10px;
	color: #333333;
}
.cuubez-section .cuubez-ui-wrap q:before, .cuubez-section .cuubez-ui-wrap q:after, .cuubez-section .cuubez-ui-wrap blockquote:before, .cuubez-section .cuubez-ui-wrap blockquote:after {
	content: none;
}
.cuubez-section .cuubez-ui-wrap .heading_with_menu h1, .cuubez-section .cuubez-ui-wrap .heading_with_menu h2, .cuubez-section .cuubez-ui-wrap .heading_with_menu h3, .cuubez-section .cuubez-ui-wrap .heading_with_menu h4, .cuubez-section .cuubez-ui-wrap .heading_with_menu h5, .cuubez-section .cuubez-ui-wrap .heading_with_menu h6 {
	display: block;
	clear: none;
	float: left;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-ms-box-sizing: border-box;
	box-sizing: border-box;
	width: 60%;
}
.cuubez-section .cuubez-ui-wrap table {
	border-collapse: collapse;
	border-spacing: 0;
}
.cuubez-section .cuubez-ui-wrap table thead tr th {
	padding: 5px;
	font-size: 0.9em;
	color: #666666;
	border-bottom: 1px solid #999999;
}
.cuubez-section .cuubez-ui-wrap table tbody tr:last-child td {
	border-bottom: none;
}
.cuubez-section .cuubez-ui-wrap table tbody tr.offset {
	background-color: #f0f0f0;
}
.cuubez-section .cuubez-ui-wrap table tbody tr td {
	padding: 6px;
	font-size: 0.9em;
	border-bottom: 1px solid #cccccc;
	vertical-align: top;
	line-height: 1.3em;
}
.cuubez-section .cuubez-ui-wrap ol {
	margin: 0px 0 10px;
	padding: 0 0 0 18px;
	list-style-type: decimal;
}
.cuubez-section .cuubez-ui-wrap ol li {
	padding: 5px 0px;
	font-size: 0.9em;
	color: #333333;
}
.cuubez-section .cuubez-ui-wrap ol, .cuubez-section .cuubez-ui-wrap ul {
	list-style: none;
}
.endpoints{
	margin:0 0 10px 0;
	}
.cuubez-section .cuubez-ui-wrap h1 a, .cuubez-section .cuubez-ui-wrap h2 a, .cuubez-section .cuubez-ui-wrap h3 a, .cuubez-section .cuubez-ui-wrap h4 a, .cuubez-section .cuubez-ui-wrap h5 a, .cuubez-section .cuubez-ui-wrap h6 a {
	text-decoration: none;
}
.cuubez-section .cuubez-ui-wrap h1 a:hover, .cuubez-section .cuubez-ui-wrap h2 a:hover, .cuubez-section .cuubez-ui-wrap h3 a:hover, .cuubez-section .cuubez-ui-wrap h4 a:hover, .cuubez-section .cuubez-ui-wrap h5 a:hover, .cuubez-section .cuubez-ui-wrap h6 a:hover {
	text-decoration: underline;
}
.cuubez-section .cuubez-ui-wrap h1 span.divider, .cuubez-section .cuubez-ui-wrap h2 span.divider, .cuubez-section .cuubez-ui-wrap h3 span.divider, .cuubez-section .cuubez-ui-wrap h4 span.divider, .cuubez-section .cuubez-ui-wrap h5 span.divider, .cuubez-section .cuubez-ui-wrap h6 span.divider {
	color: #aaaaaa;
}
.cuubez-section .cuubez-ui-wrap a {
	color: #547f00;
}
.cuubez-section .cuubez-ui-wrap a img {
	border: none;
}
.cuubez-section .cuubez-ui-wrap article, .cuubez-section .cuubez-ui-wrap aside, .cuubez-section .cuubez-ui-wrap details, .cuubez-section .cuubez-ui-wrap figcaption, .cuubez-section .cuubez-ui-wrap figure, .cuubez-section .cuubez-ui-wrap footer, .cuubez-section .cuubez-ui-wrap header, .cuubez-section .cuubez-ui-wrap hgroup, .cuubez-section .cuubez-ui-wrap menu, .cuubez-section .cuubez-ui-wrap nav, .cuubez-section .cuubez-ui-wrap section, .cuubez-section .cuubez-ui-wrap summary {
	display: block;
}
.cuubez-section .cuubez-ui-wrap pre {
	font-family: "Anonymous Pro", "Menlo", "Consolas", "Bitstream Vera Sans Mono", "Courier New", monospace;
	background-color: #fcf6db;
	border: 1px solid #e5e0c6;
	padding: 10px;
}
.cuubez-section .cuubez-ui-wrap pre code {
	line-height: 1.6em;
	background: none;
}
.cuubez-section .cuubez-ui-wrap .content > .content-type > div > label {
	clear: both;
	display: block;
	color: #0F6AB4;
	font-size: 1.1em;
	margin: 0;
	padding: 15px 0 5px;
}
.cuubez-section .cuubez-ui-wrap .content pre {
	font-size: 12px;
	margin-top: 5px;
	padding: 5px;
}
.cuubez-section .cuubez-ui-wrap .icon-btn {
	cursor: pointer;
}
.cuubez-section .cuubez-ui-wrap .info_title {
	padding-bottom: 10px;
	font-weight: bold;
	font-size: 25px;
}
.cuubez-section .cuubez-ui-wrap p.big, .cuubez-section .cuubez-ui-wrap div.big p {
	font-size: 1em;
	margin-bottom: 10px;
}
.cuubez-section .cuubez-ui-wrap form.fullwidth ol li.string input, .cuubez-section .cuubez-ui-wrap form.fullwidth ol li.url input, .cuubez-section .cuubez-ui-wrap form.fullwidth ol li.text textarea, .cuubez-section .cuubez-ui-wrap form.fullwidth ol li.numeric input {
	width: 500px !important;
}
.cuubez-section .cuubez-ui-wrap .info_license {
	padding-bottom: 5px;
}
.cuubez-section .cuubez-ui-wrap .info_tos {
	padding-bottom: 5px;
}
.cuubez-section .cuubez-ui-wrap .message-fail {
	color: #cc0000;
}
.cuubez-section .cuubez-ui-wrap .info_contact {
	padding-bottom: 5px;
}
.cuubez-section .cuubez-ui-wrap .info_description {
	padding-bottom: 10px;
	font-size: 15px;
}
.cuubez-section .cuubez-ui-wrap .markdown ol li, .cuubez-section .cuubez-ui-wrap .markdown ul li {
	padding: 3px 0px;
	line-height: 1.4em;
	color: #333333;
}
.cuubez-section .cuubez-ui-wrap form.formtastic fieldset.inputs ol li.string input, .cuubez-section .cuubez-ui-wrap form.formtastic fieldset.inputs ol li.url input, .cuubez-section .cuubez-ui-wrap form.formtastic fieldset.inputs ol li.numeric input {
	display: block;
	padding: 4px;
	width: auto;
	clear: both;
}
.cuubez-section .cuubez-ui-wrap form.formtastic fieldset.inputs ol li.string input.title, .cuubez-section .cuubez-ui-wrap form.formtastic fieldset.inputs ol li.url input.title, .cuubez-section .cuubez-ui-wrap form.formtastic fieldset.inputs ol li.numeric input.title {
	font-size: 1.3em;
}
.cuubez-section .cuubez-ui-wrap table.fullwidth {
	width: 100%;
}
.cuubez-section .cuubez-ui-wrap .model-signature {
	font-family: "Droid Sans", sans-serif;
	font-size: 1em;
	line-height: 1.5em;
}
.cuubez-section .cuubez-ui-wrap .model-signature .signature-nav a {
	text-decoration: none;
	color: #AAA;
}
.cuubez-section .cuubez-ui-wrap .model-signature .signature-nav a:hover {
	text-decoration: underline;
	color: black;
}
.cuubez-section .cuubez-ui-wrap .model-signature .signature-nav .selected {
	color: black;
	text-decoration: none;
}
.cuubez-section .cuubez-ui-wrap .model-signature .propType {
	color: #5555aa;
}
.cuubez-section .cuubez-ui-wrap .model-signature pre:hover {
	background-color: #ffffdd;
}
.cuubez-section .cuubez-ui-wrap .model-signature pre {
	font-size: .85em;
	line-height: 1.2em;
	overflow: auto;
	max-height: 200px;
	cursor: pointer;
}
.cuubez-section .cuubez-ui-wrap .model-signature ul.signature-nav {
	display: block;
	margin: 0;
	padding: 0;
}
.cuubez-section .cuubez-ui-wrap .model-signature ul.signature-nav li:last-child {
	padding-right: 0;
	border-right: none;
}
.cuubez-section .cuubez-ui-wrap .model-signature ul.signature-nav li {
	float: left;
	margin: 0 5px 5px 0;
	padding: 2px 5px 2px 0;
	border-right: 1px solid #ddd;
}
.cuubez-section .cuubez-ui-wrap .model-signature .propOpt {
	color: #555;
}
.cuubez-section .cuubez-ui-wrap .model-signature .snippet small {
	font-size: 0.75em;
}
.cuubez-section .cuubez-ui-wrap .model-signature .propOptKey {
	font-style: italic;
}
.cuubez-section .cuubez-ui-wrap .model-signature .description .strong {
	font-weight: bold;
	color: #000;
	font-size: .9em;
}
.cuubez-section .cuubez-ui-wrap .model-signature .description div {
	font-size: 0.9em;
	line-height: 1.5em;
	margin-left: 1em;
}
.cuubez-section .cuubez-ui-wrap .model-signature .description .stronger {
	font-weight: bold;
	color: #000;
}
.cuubez-section .cuubez-ui-wrap .model-signature .propName {
	font-weight: bold;
}
.cuubez-section .cuubez-ui-wrap .model-signature .signature-container {
	clear: both;
}
.cuubez-section .cuubez-ui-wrap .body-textarea {
	width: 846px !important;
	height: 150px !important;
	border: 1px solid #aaa !important;
	border-radius:2px;
	-webkit-box-shadow: 0 8px 6px -6px black; -moz-box-shadow: 0 8px 6px -6px black;  box-shadow: 0 8px 6px -6px black;
}
.cuubez-section .cuubez-ui-wrap .markdown p code, .cuubez-section .cuubez-ui-wrap .markdown li code {
	font-family: "Anonymous Pro", "Menlo", "Consolas", "Bitstream Vera Sans Mono", "Courier New", monospace;
	background-color: #f0f0f0;
	color: black;
	padding: 1px 3px;
}
.cuubez-section .cuubez-ui-wrap .required {
	font-weight: bold;
}
.cuubez-section .cuubez-ui-wrap input.parameter {
	width: 300px;
	border: 1px solid #aaa;
}
.cuubez-section .cuubez-ui-wrap h1 {
	color: black;
	font-size: 1.5em;
	line-height: 1.3em;
	padding: 10px 0 10px 0;
	font-family: "Droid Sans", sans-serif;
	font-weight: bold;
}
.cuubez-section .cuubez-ui-wrap .heading_with_menu {
	float: none;
	clear: both;
	overflow: hidden;
	display: block;
}
.cuubez-section .cuubez-ui-wrap .heading_with_menu ul {
	display: block;
	clear: none;
	float: right;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-ms-box-sizing: border-box;
	box-sizing: border-box;
	margin-top: 10px;
}
.cuubez-section .cuubez-ui-wrap h2 {
	color: black;
	font-size: 1.3em;
	padding: 10px 0 10px 0;
}
.cuubez-section .cuubez-ui-wrap h2 a {
	color: black;
}
.cuubez-section .cuubez-ui-wrap h2 span.sub {
	font-size: 0.7em;
	color: #999999;
	font-style: italic;
}
.cuubez-section .cuubez-ui-wrap h2 span.sub a {
	color: #777777;
}
.cuubez-section .cuubez-ui-wrap span.weak {
	color: #666666;
}
.cuubez-section .cuubez-ui-wrap .message-success {
	color: #89BF04;
}
.cuubez-section .cuubez-ui-wrap caption, .cuubez-section .cuubez-ui-wrap th, .cuubez-section .cuubez-ui-wrap td {
	text-align: left;
	font-weight: normal;
	vertical-align: middle;
}
.cuubez-section .cuubez-ui-wrap .code {
	font-family: "Anonymous Pro", "Menlo", "Consolas", "Bitstream Vera Sans Mono", "Courier New", monospace;
}
.cuubez-section .cuubez-ui-wrap form.formtastic fieldset.inputs ol li.text textarea {
	font-family: "Droid Sans", sans-serif;
	height: 250px;
	padding: 4px;
	display: block;
	clear: both;
}
.cuubez-section .cuubez-ui-wrap form.formtastic fieldset.inputs ol li.select select {
	display: block;
	clear: both;
}
.cuubez-section .cuubez-ui-wrap form.formtastic fieldset.inputs ol li.boolean {
	float: none;
	clear: both;
	overflow: hidden;
	display: block;
}
.cuubez-section .cuubez-ui-wrap form.formtastic fieldset.inputs ol li.boolean label {
	display: block;
	float: left;
	clear: none;
	margin: 0;
	padding: 0;
}
.cuubez-section .cuubez-ui-wrap form.formtastic fieldset.inputs ol li.boolean input {
	display: block;
	float: left;
	clear: none;
	margin: 0 5px 0 0;
}
.cuubez-section .cuubez-ui-wrap form.formtastic fieldset.inputs ol li.required label {
	color: black;
}
.cuubez-section .cuubez-ui-wrap form.formtastic fieldset.inputs ol li label {
	display: block;
	clear: both;
	width: auto;
	padding: 0 0 3px;
	color: #666666;
}
.cuubez-section .cuubez-ui-wrap form.formtastic fieldset.inputs ol li label abbr {
	padding-left: 3px;
	color: #888888;
}
.cuubez-section .cuubez-ui-wrap form.formtastic fieldset.inputs ol li p.inline-hints {
	margin-left: 0;
	font-style: italic;
	font-size: 0.9em;
	margin: 0;
}
.cuubez-section .cuubez-ui-wrap form.formtastic fieldset.buttons {
	margin: 0;
	padding: 0;
}
.cuubez-section .cuubez-ui-wrap span.blank, .cuubez-section .cuubez-ui-wrap span.empty {
	color: #888888;
	font-style: italic;
}
.cuubez-section .cuubez-ui-wrap .markdown h3 {
	color: #547f00;
}
.cuubez-section .cuubez-ui-wrap .markdown h4 {
	color: #666666;
}
.cuubez-section .cuubez-ui-wrap .markdown pre {
	font-family: "Anonymous Pro", "Menlo", "Consolas", "Bitstream Vera Sans Mono", "Courier New", monospace;
	background-color: #fcf6db;
	border: 1px solid #e5e0c6;
	padding: 10px;
	margin: 0 0 10px 0;
}
.cuubez-section .cuubez-ui-wrap .markdown pre code {
	line-height: 1.6em;
}
.cuubez-section .cuubez-ui-wrap div.gist {
	margin: 20px 0 25px 0 !important;
}
.cuubez-section .cuubez-ui-wrap ul#resources {
	font-family: "Droid Sans", sans-serif;
	font-size: 0.9em;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource {
	border-bottom: 1px solid #dddddd;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource:hover div.heading h2 a, .cuubez-section .cuubez-ui-wrap ul#resources li.resource.active div.heading h2 a {
	color: black;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource:hover div.heading ul.options li a, .cuubez-section .cuubez-ui-wrap ul#resources li.resource.active div.heading ul.options li a {
	color: #555555;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource:last-child {
	border-bottom: none;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource div.heading {
	border: 1px solid transparent;
	float: none;
	clear: both;
	overflow: hidden;
	display: block;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource div.heading ul.options {
	overflow: hidden;
	padding: 0;
	display: block;
	clear: none;
	float: right;
	margin: 14px 10px 0 0;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource div.heading ul.options li {
	float: left;
	clear: none;
	margin: 0;
	padding: 2px 10px;
	border-right: 1px solid #dddddd;
	color: #666666;
	font-size: 0.9em;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource div.heading ul.options li a {
	color: #aaaaaa;
	text-decoration: none;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource div.heading ul.options li a:hover {
	text-decoration: underline;
	color: black;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource div.heading ul.options li a:hover, .cuubez-section .cuubez-ui-wrap ul#resources li.resource div.heading ul.options li a:active, .cuubez-section .cuubez-ui-wrap ul#resources li.resource div.heading ul.options li a.active {
	text-decoration: underline;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource div.heading ul.options li:first-child, .cuubez-section .cuubez-ui-wrap ul#resources li.resource div.heading ul.options li.first {
	padding-left: 0;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource div.heading ul.options li:last-child, .cuubez-section .cuubez-ui-wrap ul#resources li.resource div.heading ul.options li.last {
	padding-right: 0;
	border-right: none;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource div.heading ul.options:first-child, .cuubez-section .cuubez-ui-wrap ul#resources li.resource div.heading ul.options.first {
	padding-left: 0;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource div.heading h2 {
	color: #999999;
	padding-left: 0;
	display: block;
	clear: none;
	float: left;
	font-family: "Droid Sans", sans-serif;
	font-weight: bold;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource div.heading h2 a {
	color: #999999;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource div.heading h2 a:hover {
	color: black;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation {
	float: none;
	clear: both;
	overflow: hidden;
	display: block;
	margin: 0 0 10px;
	padding: 0;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation div.heading {
	float: none;
	clear: both;
	overflow: hidden;
	display: block;
	margin: 0;
	padding: 0;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation div.heading h3 {
	display: block;
	clear: none;
	float: left;
	width: auto;
	margin: 0;
	padding: 0;
	line-height: 1.1em;
	color: black;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation div.heading h3 span.path {
	padding-left: 10px;
	font-weight:normal;
	text-shadow:0 1px #fff;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation div.heading h3 span.path a {
	color: black;
	text-decoration: none;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation div.heading h3 span.path a:hover {
	text-decoration: underline;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation div.heading h3 span.http_method a {
	text-transform: uppercase;
	text-decoration: none;
	color: white;
	display: inline-block;
	width: 60px;
	font-size: 0.7em;
	text-align: center;
	padding: 7px 0 4px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	-o-border-radius: 2px;
	-ms-border-radius: 2px;
	-khtml-border-radius: 2px;
	border-radius: 2px;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation div.heading h3 span {
	margin: 0;
	padding: 0;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation div.heading ul.options {
	overflow: hidden;
	padding: 0;
	display: block;
	clear: none;
	float: right;
	margin: 6px 10px 0 0;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation div.heading ul.options li {
	float: left;
	clear: none;
	margin: 0;
	padding: 2px 10px;
	font-size: 0.9em;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation div.heading ul.options li a {
	text-decoration: none;
	text-shadow:0 1px #fff;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation div.heading ul.options li.access {
	color: black;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation div.content {
	border-top: none;
	border-radius:2px;
	margin: 0 0 20px;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation div.content h4 {
	font-size: 16px;
	margin: 0;
	padding: 15px 0;
	font-weight:normal;
	text-shadow:0 1px #fff;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation div.content div.sandbox_header {
	float: none;
	clear: both;
	overflow: hidden;
	display: block;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation div.content div.sandbox_header a {
	padding: 4px 0 0 10px;
	display: inline-block;
	font-size: 0.9em;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation div.content div.sandbox_header img {
	display: block;
	clear: none;
	float: right;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation div.content div.sandbox_header input.submit {
	display: block;
	clear: none;
	float: left;
	padding: 6px 8px;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation div.content form input[type='text'].error {
	outline: 2px solid black;
	outline-color: #cc0000;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation div.content div.response div.block pre {
	font-family: "Anonymous Pro", "Menlo", "Consolas", "Bitstream Vera Sans Mono", "Courier New", monospace;
	padding: 10px;
	font-size: 0.9em;
	max-height: 400px;
	overflow-y: auto;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.put div.heading {
	background-color: #ffead0;
	border: 1px solid #ffc377;
	border-radius: 2px;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.put div.heading h3 span.http_method a {
	/*background-color: #c5862b;*/

	background: rgba(255,175,75,1);
	background: -moz-linear-gradient(top, rgba(255,175,75,1) 0%, rgba(255,146,10,1) 100%);
	background: -webkit-gradient(left top, left bottom, color-stop(0%, rgba(255,175,75,1)), color-stop(100%, rgba(255,146,10,1)));
	background: -webkit-linear-gradient(top, rgba(255,175,75,1) 0%, rgba(255,146,10,1) 100%);
	background: -o-linear-gradient(top, rgba(255,175,75,1) 0%, rgba(255,146,10,1) 100%);
	background: -ms-linear-gradient(top, rgba(255,175,75,1) 0%, rgba(255,146,10,1) 100%);
	background: linear-gradient(to bottom, rgba(255,175,75,1) 0%, rgba(255,146,10,1) 100%);
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ffaf4b', endColorstr='#ff920a', GradientType=0 );
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.put div.heading ul.options li {
	border-right: 1px solid #dddddd;
	border-right-color: #f0e0ca;
	color: #c5862b;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.put div.heading ul.options li a {
	color: #c5862b;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.put div.content {
	background-color: #fff3e5;
	border: 1px solid #ffc377;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.put div.content h4 {
	color: #c5862b;

}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.put div.content div.sandbox_header a {
	color: #dcb67f;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.head div.heading {
	background-color: #fcffcd;
	border: 1px solid black;
	border-color: #ffd20f;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.head div.heading h3 span.http_method a {
	text-transform: uppercase;
	background-color: #ffd20f;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.head div.heading ul.options li {
	border-right: 1px solid #dddddd;
	border-right-color: #ffd20f;
	color: #ffd20f;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.head div.heading ul.options li a {
	color: #ffd20f;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.head div.content {
	background-color: #fcffcd;
	border: 1px solid black;
	border-color: #ffd20f;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.head div.content h4 {
	color: #ffd20f;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.head div.content div.sandbox_header a {
	color: #6fc992;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.delete div.heading {
	background-color: #ffe8e8;
	border: 1px solid #be3939;
	border-radius:2px;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.delete div.heading h3 span.http_method a {
	text-transform: uppercase;background: rgba(255,160,143,1);
	background: -moz-linear-gradient(top, rgba(255,160,143,1) 0%, rgba(240,47,23,1) 67%, rgba(231,56,39,1) 100%);
	background: -webkit-gradient(left top, left bottom, color-stop(0%, rgba(255,160,143,1)), color-stop(67%, rgba(240,47,23,1)), color-stop(100%, rgba(231,56,39,1)));
	background: -webkit-linear-gradient(top, rgba(255,160,143,1) 0%, rgba(240,47,23,1) 67%, rgba(231,56,39,1) 100%);
	background: -o-linear-gradient(top, rgba(255,160,143,1) 0%, rgba(240,47,23,1) 67%, rgba(231,56,39,1) 100%);
	background: -ms-linear-gradient(top, rgba(255,160,143,1) 0%, rgba(240,47,23,1) 67%, rgba(231,56,39,1) 100%);
	background: linear-gradient(to bottom, rgba(255,160,143,1) 0%, rgba(240,47,23,1) 67%, rgba(231,56,39,1) 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ffa08f', endColorstr='#e73827', GradientType=0 )
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.delete div.heading ul.options li {
	border-right: 1px solid #dddddd;
	border-right-color: #e8c6c7;
	color: #a41e22;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.delete div.heading ul.options li a {
	color: #a41e22;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.delete div.content {
	background-color: #f7eded;
	border: 1px solid #be3939;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.delete div.content h4 {
	color: #a41e22;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.delete div.content div.sandbox_header a {
	color: #c8787a;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.post div.heading {
	background-color: #ccffdd;
	border: 1px solid #00a236;
	border-radius:2px;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.post div.heading h3 span.http_method a {
	/*background-color: #10a54a;*/
	background: rgba(34,235,112,1);
	background: -moz-linear-gradient(top, rgba(34,235,112,1) 0%, rgba(16,165,74,1) 100%);
	background: -webkit-gradient(left top, left bottom, color-stop(0%, rgba(34,235,112,1)), color-stop(100%, rgba(16,165,74,1)));
	background: -webkit-linear-gradient(top, rgba(34,235,112,1) 0%, rgba(16,165,74,1) 100%);
	background: -o-linear-gradient(top, rgba(34,235,112,1) 0%, rgba(16,165,74,1) 100%);
	background: -ms-linear-gradient(top, rgba(34,235,112,1) 0%, rgba(16,165,74,1) 100%);
	background: linear-gradient(to bottom, rgba(34,235,112,1) 0%, rgba(16,165,74,1) 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#22eb70', endColorstr='#10a54a', GradientType=0 );
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.post div.heading ul.options li {
	border-right: 1px solid #dddddd;
	border-right-color: #c3e8d1;
	color: #10a54a;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.post div.heading ul.options li a {
	color: #10a54a;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.post div.content {
	background-color: #e8fff0;
	border: 1px solid #00a236;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.post div.content h4 {
	color: #10a54a;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.post div.content div.sandbox_header a {
	color: #6fc992;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.patch div.heading {
	background-color: #FCE9E3;
	border: 1px solid #F5D5C3;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.patch div.heading h3 span.http_method a {
	background-color: #D38042;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.patch div.heading ul.options li {
	border-right: 1px solid #dddddd;
	border-right-color: #f0cecb;
	color: #D38042;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.patch div.heading ul.options li a {
	color: #D38042;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.patch div.content {
	background-color: #faf0ef;
	border: 1px solid #f0cecb;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.patch div.content h4 {
	color: #D38042;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.patch div.content div.sandbox_header a {
	color: #dcb67f;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.get div.heading {
	background-color: #c6e0f5;
	border: 1px solid #0074d9;
	border-radius:2px;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.get div.heading h3 span.http_method a {

background: rgba(120,179,235,1);
background: -moz-linear-gradient(top, rgba(120,179,235,1) 0%, rgba(32,124,229,1) 100%);
background: -webkit-gradient(left top, left bottom, color-stop(0%, rgba(120,179,235,1)), color-stop(100%, rgba(32,124,229,1)));
background: -webkit-linear-gradient(top, rgba(120,179,235,1) 0%, rgba(32,124,229,1) 100%);
background: -o-linear-gradient(top, rgba(120,179,235,1) 0%, rgba(32,124,229,1) 100%);
background: -ms-linear-gradient(top, rgba(120,179,235,1) 0%, rgba(32,124,229,1) 100%);
background: linear-gradient(to bottom, rgba(120,179,235,1) 0%, rgba(32,124,229,1) 100%);
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#78b3eb', endColorstr='#207ce5', GradientType=0 );

}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.get div.heading ul.options li {
	border-right: 1px solid #dddddd;
	border-right-color: #c3d9ec;
	color: #0f6ab4;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.get div.heading ul.options li a {
	color: #0f6ab4;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.get div.content {
	background-color: #e5f3ff;
	border: 1px solid #0074d9;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.get div.content h4 {
	color: #0f6ab4;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.get div.content div.sandbox_header a {
	color: #6fa5d2;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.options div.heading {
	background-color: #e7f0f7;
	border: 1px solid #c3d9ec;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.options div.heading h3 span.http_method a {
	background-color: #0f6ab4;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.options div.heading ul.options li {
	border-right: 1px solid #dddddd;
	border-right-color: #c3d9ec;
	color: #0f6ab4;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.options div.heading ul.options li a {
	color: #0f6ab4;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.options div.content {
	background-color: #ebf3f9;
	border: 1px solid #c3d9ec;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.options div.content h4 {
	color: #0f6ab4;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.options div.content div.sandbox_header a {
	color: #6fa5d2;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.get div.content, .cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.post div.content, .cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.head div.content, .cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.put div.content, .cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.patch div.content, .cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.delete div.content {
	border-top: none;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.get div.heading ul.options li:last-child, .cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.post div.heading ul.options li:last-child, .cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.head div.heading ul.options li:last-child, .cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.put div.heading ul.options li:last-child, .cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.patch div.heading ul.options li:last-child, .cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.delete div.heading ul.options li:last-child, .cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.get div.heading ul.options li.last, .cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.post div.heading ul.options li.last, .cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.head div.heading ul.options li.last, .cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.put div.heading ul.options li.last, .cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.patch div.heading ul.options li.last, .cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations li.operation.delete div.heading ul.options li.last {
	padding-right: 0;
	border-right: none;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations ul.options li a:hover, .cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations ul.options li a:active, .cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations ul.options li a.active {
	text-decoration: underline;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations ul.options li:first-child, .cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations ul.options li.first {
	padding-left: 0;
}
.cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations:first-child, .cuubez-section .cuubez-ui-wrap ul#resources li.resource ul.endpoints li.endpoint ul.operations.first {
	padding-left: 0;
}
.cuubez-section .cuubez-ui-wrap p#colophon {
	margin: 0 15px 40px 15px;
	padding: 10px 0;
	font-size: 0.8em;
	border-top: 1px solid #dddddd;
	font-family: "Droid Sans", sans-serif;
	color: #999999;
	font-style: italic;
}
.cuubez-section .cuubez-ui-wrap p#colophon a {
	text-decoration: none;
	color: #547f00;
}
.cuubez-section .cuubez-ui-wrap h3 {
	color: black;
	font-size: 1.1em;
	padding: 10px 0 10px 0;
}
.cuubez-section .cuubez-ui-wrap .markdown ol, .cuubez-section .cuubez-ui-wrap .markdown ul {
	font-family: "Droid Sans", sans-serif;
	margin: 5px 0 10px;
	padding: 0 0 0 18px;
	list-style-type: disc;
}
.cuubez-section .cuubez-ui-wrap form.form_box {
	background-color: #ebf3f9;
	border: 1px solid #c3d9ec;
	padding: 10px;
}
.cuubez-section .cuubez-ui-wrap form.form_box label {
	color: #0f6ab4 !important;
}
.cuubez-section .cuubez-ui-wrap form.form_box input[type=submit] {
	display: block;
	padding: 10px;
}
.cuubez-section .cuubez-ui-wrap form.form_box p.weak {
	font-size: 0.8em;
}
.cuubez-section .cuubez-ui-wrap form.form_box p {
	font-size: 0.9em;
	padding: 0 0 15px;
	color: #7e7b6d;
}
.cuubez-section .cuubez-ui-wrap form.form_box p a {
	color: #646257;
}
.cuubez-section .cuubez-ui-wrap form.form_box p strong {
	color: black;
}
.cuubez-section .title {
	font-style: bold;
}
.cuubez-section .secondary_form {
	display: none;
}
.cuubez-section .main_image {
	display: block;
	margin-left: auto;
	margin-right: auto;
}
.cuubez-section .oauth_body {
	margin-left: 100px;
	margin-right: 100px;
}
.cuubez-section .oauth_submit {
	text-align: center;
}
.cuubez-section .api-popup-dialog {
	z-index: 10000;
	position: absolute;
	width: 500px;
	background: #FFF;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	display: none;
	font-size: 13px;
	color: #777;
}
.cuubez-section .api-popup-dialog .api-popup-title {
	font-size: 24px;
	padding: 10px 0;
}
.cuubez-section .api-popup-dialog .api-popup-title {
	font-size: 24px;
	padding: 10px 0;
}
.cuubez-section .api-popup-dialog p.error-msg {
	padding-left: 5px;
	padding-bottom: 5px;
}
.cuubez-section .api-popup-dialog button.api-popup-authbtn {
	height: 30px;
}
.cuubez-section .api-popup-dialog button.api-popup-cancel {
	height: 30px;
}
.cuubez-section .api-popup-scopes {
	padding: 10px 20px;
}
.cuubez-section .api-popup-scopes li {
	padding: 5px 0;
	line-height: 20px;
}
.cuubez-section .api-popup-scopes .api-scope-desc {
	padding-left: 20px;
	font-style: italic;
}
.cuubez-section .api-popup-scopes li input {
	position: relative;
	top: 2px;
}
.cuubez-section .api-popup-actions {
	padding-top: 10px;
}
.cuubez-section .access {
	float: right;
}
.cuubez-section .auth {
	float: right;
}
.cuubez-section #api_information_panel {
	position: absolute;
	background: #FFF;
	border: 1px solid #ccc;
	border-radius: 5px;
	display: none;
	font-size: 13px;
	max-width: 300px;
	line-height: 30px;
	color: black;
	padding: 5px;
}
.cuubez-section #api_information_panel p .api-msg-enabled {
	color: green;
}
.cuubez-section #api_information_panel p .api-msg-disabled {
	color: red;
}
.cuubez-section .api-ic {
	height: 18px;
	vertical-align: middle;
	display: inline-block;
	background: url(../images/explorer_icons.png) no-repeat;
}
.cuubez-section .ic-info {
	background-position: 0 0;
	width: 18px;
	margin-top: -7px;
	margin-left: 4px;
}
.cuubez-section .ic-warning {
	background-position: -60px 0;
	width: 18px;
	margin-top: -7px;
	margin-left: 4px;
}
.cuubez-section .ic-error {
	background-position: -30px 0;
	width: 18px;
	margin-top: -7px;
	margin-left: 4px;
}
.cuubez-section .ic-off {
	background-position: -90px 0;
	width: 58px;
	margin-top: -4px;
	cursor: pointer;
}
.cuubez-section .ic-on {
	background-position: -160px 0;
	width: 58px;
	margin-top: -4px;
	cursor: pointer;
}
.cuubez-section #header {
	background-color: #89bf04;
	padding: 14px;
}
.cuubez-section #header a#logo {
	font-size: 1.5em;
	font-weight: bold;
	text-decoration: none;
	background: transparent url(../images/logo_small.png) no-repeat left center;
	padding: 20px 0 20px 40px;
	color: white;
}
.cuubez-section #header form#api_selector {
	display: block;
	clear: none;
	float: right;
}
.cuubez-section #header form#api_selector .input {
	display: block;
	clear: none;
	float: left;
	margin: 0 10px 0 0;
}
.cuubez-section #header form#api_selector .input input#input_apiKey {
	width: 200px;
}
.cuubez-section #header form#api_selector .input input#input_baseUrl {
	width: 400px;
}
.cuubez-section #header form#api_selector .input a#explore {
	display: block;
	text-decoration: none;
	font-weight: bold;
	padding: 6px 8px;
	font-size: 0.9em;
	color: white;
	background-color: #547f00;
	-moz-border-radius: 4px;
	-webkit-border-radius: 4px;
	-o-border-radius: 4px;
	-ms-border-radius: 4px;
	-khtml-border-radius: 4px;
	border-radius: 4px;
}
.cuubez-section #header form#api_selector .input a#explore:hover {
	background-color: #547f00;
}
.cuubez-section #header form#api_selector .input input {
	font-size: 0.9em;
	padding: 3px;
	margin: 0;
}
.cuubez-section #content_message {
	margin: 10px 15px;
	font-style: italic;
	color: #999999;
}
.cuubez-section #message-bar {
	min-height: 30px;
	text-align: center;
	padding-top: 10px;
}
.cuubez-ui-wrap table tr th {
	border-bottom: 1px solid #999999;
	color: #666666;
	font-size: 0.9em;
	padding: 5px;
}
.cuubez-ui-wrap td {
	font-weight: normal;
	text-align: left;
	vertical-align: middle;
}
.mandatory_dot {
	background: #FF0000;
	width: 10px;
	height: 10px;
	border-radius: 50%;
}
.group {
	background: rgba(255,255,255,1);
	background: -moz-linear-gradient(top, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 47%, rgba(237,237,237,1) 100%);
	background: -webkit-gradient(left top, left bottom, color-stop(0%, rgba(255,255,255,1)), color-stop(47%, rgba(246,246,246,1)), color-stop(100%, rgba(237,237,237,1)));
	background: -webkit-linear-gradient(top, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 47%, rgba(237,237,237,1) 100%);
	background: -o-linear-gradient(top, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 47%, rgba(237,237,237,1) 100%);
	background: -ms-linear-gradient(top, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 47%, rgba(237,237,237,1) 100%);
	background: linear-gradient(to bottom, rgba(255,255,255,1) 0%, rgba(246,246,246,1) 47%, rgba(237,237,237,1) 100%);
 filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ffffff', endColorstr='#ededed', GradientType=0 );
	border-radius: 2px;
	border: 1px solid #a7a7a7;
	margin: 2em 0 1em;
	position:relative;
	cursor:pointer;
}
.expand_div { position:absolute; top:7px; right:0;}
.group h2 {
	margin: 0;
	padding: 10px 0 10px 10px !important;
	border-radius: 2px;
	border: 1px solid #fff;
	font-weight: normal;
	font-size: 14px;
	text-shadow: 0 1px #fff;
	color: #505050 !important;
}
.header {
	background-color: #dfdfdf;
	padding: 0;
	margin: 0 0 15px 0;
	width: 100%;
	border-bottom: 1px solid #b1b1b1;
}
.header_inner {
	padding: 10px 0;
	width: 100%;
	height: 60px;
	border-bottom: 1px solid #fff;
}
.header_inner table {
	width: 960px !important;
	margin: 0 auto;
}
.first_td {
	text-align: left;
	border-right: 1px solid #b1b1b1;
	width: 120px;
	padding: 0 20px 0 0
}
.secondt_td {
	border-left: 1px solid #fff;
	text-align: left;
}
.footer {
	background-color: #dfdfdf;
	width: 100%;
	border-top: 1px solid #b1b1b1;
	position: fixed;
	bottom: 0;
	left: 0;
}
.footer_inner {
	padding: 10px 0;
	width: 100%;
	height: 20px;
	border-top: 1px solid #fff;
	text-align: center;
	font-family: 'Century Gothic', Tahoma, Geneva, sans-serif;
	font-size: 14px;
	text-shadow: 0 1px #fff;
}
.logo {
	padding: 0 10px 0 0;
}
.header_tittle {
	margin: 1em 0 0.5em 0;
	font-family: 'Century Gothic', Tahoma, Geneva, sans-serif;
	font-size: 27px;
	line-height: 40px;
	padding: 15px;
	color: #990000;
	text-shadow: 0 1px #fff;
	font-weight: 100;
}
h6 {
	font-size: 14px;
	font-weight: bold;
	margin: 10px 0;
	width: 100%;
}
p {
	font-size: 12px;
	margin: 0 0 10px 0;
	width: 100%;
}
ul {
	margin: 0;
	padding: 0;
}
.heading .inner , .content .inner { border:1px solid #fff; border-radius:2px; padding:2px; float:left; width:952px;}
.clear { clear:both;}
.fullwidth { width:90% !important; margin:0 auto 10px; padding:0; border:1px solid #acaa97; border-radius:2px; border-collapse:separate !important; background:#f8f8f8;-webkit-box-shadow: 0 8px 6px -6px black; -moz-box-shadow: 0 8px 6px -6px black;  box-shadow: 0 8px 6px -6px black;}
.fullwidth tr th { background:#d0d0d0; border:1px solid #fff; border-right:1px solid #acaa97; border-bottom:1px solid #fff !important; color:#272727 !important; font-size:14px; text-shadow:0 1px #fff;}
.fullwidth tr th:last-child { border-right:1px solid #fff;}
.fullwidth tr td { border:1px solid #fff; border-right:1px solid #acaa97; border-top:1px solid #acaa97 !important;border-bottom:1px solid #fff !important; font-size:12px; font-weight:normal; color:#5c5c5c !important;}
.fullwidth tr td:last-child { border-right:1px solid #fff;}
.sabdbox_title { text-transform:uppercase; font-size:15px; text-shadow:0 1px #fff; margin:10px 0 0; float:left;}
hr { background:#363636; color:#fff; width:100%; float:left; clear:both;}

.operations h6 { font-size:25px; font-weight:normal;}
.plus { display:none; float:right; margin:0 10px; line-height:28px; font-size:30px; text-shadow:0 1px #fff; color:#3d3d3d;}
.minus { float:right; margin:0 10px; line-height:28px; font-size:30px; text-shadow:0 1px #fff; color:#3d3d3d;}
#list_one, #list_two { display:none;}
</style>
<script>

function showDiv(id) {

  if(document.getElementById(id).style.display === "block") {
    document.getElementById(id).style.display = "none";
  } else {
    document.getElementById(id).style.display = "block";
  }


}
function collaps(id){
	 if(document.getElementById(id).style.display === "block") {
    	document.getElementById(id).style.display = "none";
		document.getElementById(id+'plus').style.display = "block";
		document.getElementById(id+'minus').style.display = "none";
	  } else {
		document.getElementById(id).style.display = "block";
		document.getElementById(id+'plus').style.display = "none";
		document.getElementById(id+'minus').style.display = "block";
	  }
	}


</script>
<#if apiMetaDataInfo?? && apiMetaDataInfo.display?? && apiMetaDataInfo.display.header??>
	<title>${apiMetaDataInfo.display.header}</title>
<#else>
	<title>Cuubez API Document</title>
</#if>

</head>

<body class="cuubez-section">
<div class="header">
  <div class="header_inner">
    <table cellpadding="0" cellspacing="0">
      <tbody>
        <tr>
          <td class="first_td">
          	<span class="logo">
          	   <#if apiMetaDataInfo?? && apiMetaDataInfo.display?? && apiMetaDataInfo.display.logoUrl?? && apiMetaDataInfo.display.logoInclude>
          			<img src="${apiMetaDataInfo.display.logoUrl}">
          		<#else>
          		   <img src="https://code.google.com/p/cuubez/logo?cct=1409036089">
          		</#if>
          	</span>
          </td>
          <td class="secondt_td">
          	<span class="header_tittle">
          	  <#if apiMetaDataInfo?? && apiMetaDataInfo.display?? && apiMetaDataInfo.display.tittle??>
          	  		${apiMetaDataInfo.display.tittle}
          	  <#else>
          	  		API Documentation
          	  </#if>
          	</span>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</div>

<div id="cuubez-ui-container" class="cuubez-ui-wrap">
  <div class="container" id="resources_container">
    <ul id="resources">
      <li class="operations">
        <#if apiMetaDataInfo?? && apiMetaDataInfo.display?? && apiMetaDataInfo.display.description?? && apiMetaDataInfo.display.description.header??>
        		<h6>${apiMetaDataInfo.display.description.header}</h6>
        </#if>
        <#if apiMetaDataInfo?? && apiMetaDataInfo.display?? && apiMetaDataInfo.display.description?? && apiMetaDataInfo.display.description.description??>
        		<p>${apiMetaDataInfo.display.description.description}</p>
        </#if>
      <li class="resource">
       <#if apiMetaDataInfo?? && apiMetaDataInfo.apiMetaData??>
         <#list apiMetaDataInfo.apiMetaData?keys as groupKey>
          	<div onClick="collaps('${apiMetaDataInfo.apiMetaData[groupKey].id}')" class="group">
            <h2 >${apiMetaDataInfo.apiMetaData[groupKey].groupName}  : ${apiMetaDataInfo.apiMetaData[groupKey].groupTittle}</h2>
            <div class="expand_div">
                 <div class="plus" id="${apiMetaDataInfo.apiMetaData[groupKey].id}plus">
                            +
                 </div>
                 <div class="minus" id="${apiMetaDataInfo.apiMetaData[groupKey].id}minus">
                    -
                 </div>
             </div>
				</div>
<ul class="endpoints" id="${apiMetaDataInfo.apiMetaData[groupKey].id}">
				<#if apiMetaDataInfo.apiMetaData[groupKey]?? && apiMetaDataInfo.apiMetaData[groupKey].apiMetaDataList??>
            	<#list apiMetaDataInfo.apiMetaData[groupKey].apiMetaDataList as api>


          <li class="endpoint">

            <ul class="operations">
               <#if api.httpMethod == 'GET'>
                 <li class="get operation">
               <#elseif api.httpMethod == 'POST'>
                 <li class="post operation">
               <#elseif api.httpMethod == 'PUT'>
                 <li class="put operation">
               <#elseif api.httpMethod == 'OPTIONS'>
                 <li class="options operation">
               <#elseif api.httpMethod == 'PATCH'>
                 <li class="patch operation">
               <#elseif api.httpMethod == 'HEAD'>
                 <li class="head operation">
               <#else>
                 <li class="delete operation">
               </#if>
              <div class="heading">
                  <div class="inner">
                    <h3> <span class="http_method"> <a href="javascript:showDiv('${api.id}')">${api.httpMethod}</a> </span> <span class="path"> <a href="">${api.path}</a> </span> </h3>

                    <ul class="options">
                      <li> <#if api.name??><a class="toggleOperation" href="">${api.name}</a> </#if></li>
                    </ul>
                  </div>
                </div>
                <div id="${api.id}" class="content" style="display:none">
                <div class="inner">
                  <div class="sandbox">
                    <div> <span class="sabdbox_title">${api.detail}</span>
                      <hr>
                      <#if api.requestContain == true>
                      <h4>Request</h4>
                      <div style="margin:0;padding:0;display:inline"></div>
                      <#if api.requestParamContain == true>
                      <table class="fullwidth">
                        <tbody>
                          <tr>
                            <th>&nbsp;</th>
                            <th>Parameter</th>
                            <th>Type</th>
                            <th>Description</th>
                          </tr>

                        <#if api.pathVariableMetaDataList??>
                           <#list api.pathVariableMetaDataList as pathVariable>

                             <tr>
                                <td><#if pathVariable.mandatory><div class="mandatory_dot"></div><#else>&nbsp;</#if></td>
                                <td><#if pathVariable.name??><b>(PP)</b>${pathVariable.name}<#else>&nbsp;</#if></td>
                                <td><#if pathVariable.type??>${pathVariable.type}<#else>&nbsp;</#if></td>
                                <td><#if pathVariable.description??>${pathVariable.description}<#else>&nbsp;</#if></td>
                             </tr>

                            </#list>
                         </#if>

                         <#if api.queryVariableMetaDataList??>
                           <#list api.queryVariableMetaDataList as queryVariable>

                             <tr>
                                <td><#if queryVariable.mandatory><div class="mandatory_dot"></div><#else>&nbsp;</#if></td>
                                <td><#if queryVariable.name??><b>(PP)</b>${queryVariable.name}<#else>&nbsp;</#if></td>
                                <td><#if queryVariable.type??> ${queryVariable.type}<#else>&nbsp;</#if></td>
                                <td><#if queryVariable.description??> ${queryVariable.description}<#else>&nbsp;</#if></td>
                             </tr>

                            </#list>
                         </#if>

                         <#if api.headerVariableMetaDataList??>
                           <#list api.headerVariableMetaDataList as headerVariable>

                             <tr>
                                <td><#if headerVariable.mandatory><div class="mandatory_dot"></div><#else>&nbsp;</#if></td>
                                <td><#if headerVariable.name??><b>(PP)</b>${headerVariable.name}<#else>&nbsp;</#if></td>
                                <td><#if headerVariable.type??>${headerVariable.type}<#else>&nbsp;</#if></td>
                                <td><#if headerVariable.description??>${headerVariable.description}<#else>&nbsp;</#if></td>
                             </tr>

                            </#list>
                         </#if>

                        </tbody>
                      </table>
                      </#if>
                      <#if api.requestBody??>
                      <div style="margin:0;padding:0">
                        <table>
                          <tbody>
                            <tr>
                              <td><div class="code required">body</div></td>
                              <td><textarea rows="4" cols="100" class="body-textarea">${api.requestBody}</textarea></td>
                            </tr>
                          </tbody>
                        </table>
                        </div>
                        </#if>
                        </#if>

                      <#if api.responseContain == true>
                      <h4>Response</h4>
                      <div style="margin:0;padding:0;display:inline">
                      <#if api.httpResponseCodeContain == true>
                        <table class="fullwidth">
                          <tbody>
                            <tr>
                              <th>HTTP Status Code</th>
                              <th>Reason</th>
                            </tr>
                            <#list api.httpCodeMetaDataList as httpStatusCode>
                              <tr>
                                <td>${httpStatusCode.code}</td>
                                <td>${httpStatusCode.reason}</td>
                              </tr>
                            </#list>
                          </tbody>
                        </table>
                        </#if>
                        <#if api.responseBody??>
                         <div style="margin:0;padding:0">
                          <table>
                            <tbody>
                              <tr>
                                <td><div class="code required">body</div></td>
                                <td><textarea rows="4" cols="100" class="body-textarea">${api.responseBody}</textarea></td>
                              </tr>
                            </tbody>
                          </table>
                        </div>
                        </#if>
                      </div>
                      </#if>
                    </div>
                  </div>
                </div>
                <div class="clear"></div>
                </div>
              </li>
            </ul>
          </li>

             </#list>
            </#if>
          </ul>
         </#list>
       </#if>
      </li>
      </li>
    </ul>
  </div>
</div>
<div class="footer">
  <div class="footer_inner"></div>
</div>
</body>
</html>