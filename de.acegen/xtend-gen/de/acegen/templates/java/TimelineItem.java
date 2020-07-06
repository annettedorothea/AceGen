package de.acegen.templates.java;

import de.acegen.extensions.CommonExtension;
import javax.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class TimelineItem {
  @Inject
  @Extension
  private CommonExtension _commonExtension;
  
  public CharSequence generateITimelineItem() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.databind.annotation.JsonDeserialize;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@JsonDeserialize(as=TimelineItem.class)");
    _builder.newLine();
    _builder.append("public interface ITimelineItem {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String getType();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String getName();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("LocalDateTime getTimestamp();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String getData();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String getUuid();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateTimelineItem() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.time.LocalDateTime;");
    _builder.newLine();
    _builder.append("import com.fasterxml.jackson.annotation.JsonProperty;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class TimelineItem implements ITimelineItem {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String type;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String name;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private LocalDateTime timestamp;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String data;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String uuid;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public TimelineItem(");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("@JsonProperty(\"type\") String type, ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("@JsonProperty(\"name\") String name, ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("@JsonProperty(\"timestamp\") LocalDateTime timestamp, ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("@JsonProperty(\"data\") String data,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("@JsonProperty(\"uuid\") String uuid");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(") {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.type = type;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.name = name;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.timestamp = timestamp;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.data = data;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.uuid = uuid;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getType() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return type;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getName() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return name;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public LocalDateTime getTimestamp() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return timestamp;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getData() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return data;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@JsonProperty");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String getUuid() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return uuid;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String toString() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return \"TimelineItem [type=\" + type + \", name=\" + name + \", timestamp=\"");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("+ timestamp + \", uuid=\" + uuid + \"]\";");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateTimelineItemMapper() {
    StringConcatenation _builder = new StringConcatenation();
    String _copyright = this._commonExtension.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("package de.acegen;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.sql.ResultSet;");
    _builder.newLine();
    _builder.append("import java.sql.SQLException;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.mapper.RowMapper;");
    _builder.newLine();
    _builder.append("import org.jdbi.v3.core.statement.StatementContext;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class TimelineItemMapper implements RowMapper<ITimelineItem> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ITimelineItem map(ResultSet r, StatementContext ctx) throws SQLException {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return new TimelineItem(");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("r.getString(\"type\"),");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("r.getString(\"name\"),");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("r.getTimestamp(\"time\") != null ? r.getTimestamp(\"time\").toLocalDateTime() : null,");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("r.getString(\"data\"),");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("r.getString(\"uuid\")");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    String _sdg = this._commonExtension.sdg();
    _builder.append(_sdg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
}
