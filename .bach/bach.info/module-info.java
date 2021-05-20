import static com.github.sormuras.bach.api.ExternalLibraryName.*;

import com.github.sormuras.bach.api.ProjectInfo;
import com.github.sormuras.bach.api.ProjectInfo.*;

@ProjectInfo(external = @External(libraries = @ExternalLibrary(name = JAVAFX, version = "16")))
module bach.info {
  requires com.github.sormuras.bach;
}
